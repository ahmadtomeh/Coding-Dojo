from django.shortcuts import render, redirect

from . models import *

def createShow(request):
    context = {
        'add': Show.objects.last(),
    }
    return render(request, 'create.html', context)

def root(request):
    return redirect('shows/new')

""" """ """ """ """ """ """ """ """ """ """ """ """  """ """ """ """ """ """ """ """ """ """ """ """ """ """  """

def show_one(request, id):
    context = {
        'one': Show.objects.get(id = id),
    }
    return render(request, 'read_one.html',context)

def create(request):
    t = request.POST["title"]
    n = request.POST["net"]
    da = request.POST["date"]
    de = request.POST["desc"]
    a = Show(title = t, network = n, date = da, desc = de)
    a.save()
    return redirect('shows/'+str(Show.objects.last().id))

""" """ """ """ """ """ """ """ """ """ """ """ """ """  """ """ """ """ """ """ """ """ """ """ """ """ """ """

def goBack(request):
    context = {
        'all': Show.objects.all(),
    }
    return render(request,'read_all.html',context)

def update_one(request, id):
    context = {
        'one_show': Show.objects.filter(id = id),
    }
    return render(request, 'update.html',context)

def update(request):
    a = Show.objects.get(id = request.POST["id"])
    a.title = request.POST["title"]
    a.network = request.POST["net"]
    a.date = request.POST["date"]
    a.desc = request.POST["desc"]
    a.save()    
    return redirect('shows/'+str(request.POST["id"]))  

def delete(request, id):
    a = Show.objects.get(id = id)
    a.delete()   
    return redirect('/shows')
# Create your views here.
