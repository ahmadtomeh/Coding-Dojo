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
    return redirect('/dashboard')

def update(request, id):
    errors = Trees.objects.basic_validator(request.POST)
        # check if the errors dictionary has anything in it
    if len(errors) > 0:
        # if the errors dictionary contains anything, loop through each key-value pair and make a flash message
        for key, value in errors.items():
            messages.error(request, value)
        # redirect the us er back to the form to fix the errors
        return redirect('/edit/'+ str(id))
    else:
        a = Trees.objects.get(id = id)
        a.species = request.POST["species"]
        a.location = request.POST["location"]
        a.reason = request.POST["reason"]
        a.date = request.POST["date"]
        a.save()
    return redirect('/dashboard')

def plant(request):
    errors = Trees.objects.basic_validator(request.POST)
        # check if the errors dictionary has anything in it
    if len(errors) > 0:
        # if the errors dictionary contains anything, loop through each key-value pair and make a flash message
        for key, value in errors.items():
            messages.error(request, value)
        # redirect the us er back to the form to fix the errors
        return redirect('new/tree')
    else:
        s = request.POST["species"]
        l = request.POST["location"]
        r = request.POST["reason"]
        d = request.POST["date"]
        a = Trees(species = s, location = l, reason = r, date = d, planted_by = Users.objects.get(id = request.session['userid']))
        a.save()
    return redirect('/dashboard') 

def success(request):
    if 'userid' in request.session:
        context = {
            'reg': Users.objects.get(id=request.session['userid']),
            'trees': Trees.objects.all(),
        }
        
        return render(request, 'dashboard.html', context)
    else:
        return redirect('/')
    
def edit(request,id):
    if 'userid' in request.session:
        context = {
            'reg': Users.objects.get(id=request.session['userid']),
            'tree': Trees.objects.get(id = id),
        }
        
        return render(request, 'editTree.html', context)
    else:
        return redirect('/')
    
def show(request,id):
    if 'userid' in request.session:
        context = {
            'reg': Users.objects.get(id=request.session['userid']),
            'tree': Trees.objects.get(id = id),
        }
        
        return render(request, 'showOne.html', context)
    else:
        return redirect('/')

def delete(request, id):
    a = Trees.objects.get(id = id)
    a.delete()   
    return redirect('/user/account')

def userTrees(request):
    if 'userid' in request.session:
        context = {
            'reg': Users.objects.get(id=request.session['userid']),
            'trees': Trees.objects.filter(planted_by = request.session['userid']),
        }
        
        return render(request, 'userTrees.html', context)
    else:
        return redirect('/')
    
def userPlant(request):
    if 'userid' in request.session:
        context = {
            'reg': Users.objects.get(id=request.session['userid']),
        }
        
        return render(request, 'userPlant.html', context)
    else:
        return redirect('/')
    
def login(request):
    user = Users.objects.filter(email=request.POST['email2'])
    if user:
        user1=user[0]
        if bcrypt.checkpw(request.POST['pass2'].encode(), user1.password.encode()):
            request.session['userid'] = user1.id
            return redirect('/dashboard')
        else:
            return redirect('/')
    else:
        return redirect('/')
        
def logout(request):
    del request.session['userid']
    return redirect('/')
# Create your views here.
