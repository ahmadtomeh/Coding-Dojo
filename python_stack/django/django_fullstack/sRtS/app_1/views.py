from django.shortcuts import render, redirect
from . models import *
from django.contrib import messages

def root(request):
    return redirect('/shows')

def showAll(request):
    context = {
        'all': Show.objects.all(),
    }
    return render(request,'read_all.html',context)

def show_one(request, id):
    context = {
        'one': Show.objects.get(id = id),
    }
    return render(request, 'read_one.html',context)

""" """ """ """ """ """ """ """ """ """ """ """ """  """ """ """ """ """ """ """ """ """ """ """ """ """ """  """
def edit_one(request, id):
    context = {
        'one_show': Show.objects.get(id = id),
    }
    return render(request, 'update.html',context)

def edit(request):
    errors = Show.objects.basic_validator(request.POST)
        # check if the errors dictionary has anything in it
    if len(errors) > 0:
        # if the errors dictionary contains anything, loop through each key-value pair and make a flash message
        for key, value in errors.items():
            messages.error(request, value)
        # redirect the user back to the form to fix the errors
        return redirect('/shows/'+str(request.POST["id"])+'/edit')
    else:
        a = Show.objects.get(id = request.POST["id"])
        a.title = request.POST["title"]
        a.network = request.POST["net"]
        a.date = request.POST["date"]
        a.desc = request.POST["desc"]
        a.save()    
        return redirect('shows/'+str(request.POST["id"])) 

""" """ """ """ """ """ """ """ """ """ """ """ """ """  """ """ """ """ """ """ """ """ """ """ """ """ """ """
def delete(request, id):
    a = Show.objects.get(id = id)
    a.delete()   
    return redirect('/shows')

""" """ """ """ """ """ """ """ """ """ """ """ """  """ """ """ """ """ """ """ """ """ """ """ """ """ """  """

def createShow(request):
    context = {
        'add': Show.objects.last(),
    }
    return render(request, 'create.html', context)

def create(request):
    errors = Show.objects.basic_validator(request.POST)
        # check if the errors dictionary has anything in it
    if len(errors) > 0:
        # if the errors dictionary contains anything, loop through each key-value pair and make a flash message
        for key, value in errors.items():
            messages.error(request, value)
        # redirect the user back to the form to fix the errors
        return redirect('/shows/new')
    else:
        t = request.POST["title"]
        n = request.POST["net"]
        da = request.POST["date"]
        de = request.POST["desc"]
        a = Show(title = t, network = n, date = da, desc = de)
        a.save()
        return redirect('shows/'+str(Show.objects.last().id))



# Create your views here.
