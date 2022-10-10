from os import remove
from django.shortcuts import render, redirect
from . models import *
from django.contrib import messages
import bcrypt

def root(request):
    return render(request, 'index.html')

def reg(request):
    errors = Users.objects.basic_validator(request.POST)
        # check if the errors dictionary has anything in it
    if len(errors) > 0:
        # if the errors dictionary contains anything, loop through each key-value pair and make a flash message
        for key, value in errors.items():
            messages.error(request, value)
        # redirect the us er back to the form to fix the errors
        return redirect('/')
    else:
        fn = request.POST["fname"]
        ln = request.POST["lname"]
        em = request.POST["email"]
        pw = request.POST["pass"]
        pw_hash = bcrypt.hashpw(pw.encode(), bcrypt.gensalt()).decode()
        a = Users(first_name = fn, last_name = ln, email = em, password = pw_hash)
        a.save()
        request.session['userid']=a.id
    return redirect('/books') 

def success(request):
    if 'userid' in request.session:
        user1=Users.objects.get(id=request.session['userid'])
        context = {
            'reg': Users.objects.get(id=request.session['userid']),
            'books': Books.objects.all(),
            'userFAV': user1.liked_books.all(),
        }
        
        return render(request, 'success.html', context)
    else:
        return redirect('/')
    
def FavBook(request, id):
    if 'userid' in request.session:
        user1=Users.objects.get(id=request.session['userid'])
        context = {
            'reg': Users.objects.get(id=request.session['userid']),
            'books': Books.objects.get(id = id),
            'userFAV': user1.liked_books.all(),
            'fav': Books.objects.get(id = id).users.all(),
            
        }
        
        return render(request, 'fav_books.html', context)
    else:
        return redirect('/')
    
def login(request):
    errors = Users.objects.basic_validator(request.POST)
        # check if the errors dictionary has anything in it
    if len(errors) > 0:
        # if the errors dictionary contains anything, loop through each key-value pair and make a flash message
        for key, value in errors.items():
            messages.error(request, value)
        # redirect the us er back to the form to fix the errors
        return redirect('/')
    else:
        user = Users.objects.filter(email=request.POST['email2'])
        if user:
            user1=user[0]
            if bcrypt.checkpw(request.POST['pass2'].encode(), user1.password.encode()):
                request.session['userid'] = user1.id
                return redirect('/books')
            else:
                return redirect('/')
        else:
            return redirect('/')
        
def logout(request):
    del request.session['userid']
    return redirect('/')

""" """ """ """ """ """ """ """ """ """ """ """ """ """  """ """ """ """ """ """ """ """ """ """ """ """ """ """

def addBook(request):
    Books.objects.create(title = request.POST['title'], desc = request.POST['desc'], uploaded_by = Users.objects.get(id = request.session['userid']))
    Users.objects.get(id = request.session['userid']).liked_books.add(Books.objects.last())
    return redirect('/books')

def addFavBook1(request,id):
    Users.objects.get(id = request.session['userid']).liked_books.add(Books.objects.get(id = id))
    return redirect('/books')

def unFavBook(request,id):
    book=Books.objects.get(id = id)
    user=Users.objects.get(id = request.session['userid'])
    book.users.remove(user)
    return redirect('/books/' +str(id))

def addFavBook(request,id):
    book=Books.objects.get(id = id)
    user=Users.objects.get(id = request.session['userid'])
    book.users.add(user)
    return redirect('/books/' +str(id))

def update(request, id):
        a = Books.objects.get(id = id)
        a.title = request.POST["title"]
        a.desc = request.POST["desc"]
        a.save()    
        return redirect('/books/'+str(id)) 
    
def delete(request, id):
    a = Books.objects.get(id = id)
    a.delete()   
    return redirect('/books')
# Create your views here.
