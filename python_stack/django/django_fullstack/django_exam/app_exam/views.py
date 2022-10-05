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
    return redirect('/success') 

def success(request):
    if 'userid' in request.session:
        context = {
            'reg': Users.objects.get(id=request.session['userid']),
        }
        
        return render(request, 'success.html', context)
    else:
        return redirect('/')
    
def login(request):
    user = Users.objects.filter(email=request.POST['email2'])
    if user:
        user1=user[0]
        if bcrypt.checkpw(request.POST['pass2'].encode(), user1.password.encode()):
            request.session['userid'] = user1.id
            return redirect('/success')
        else:
            return redirect('/')
    else:
        return redirect('/')
        
def logout(request):
    del request.session['userid']
    return redirect('/')
# Create your views here.
