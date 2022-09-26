from django.shortcuts import render, redirect

from .models import Dojo, Ninja

def index(request):
    context = {
        "Dojo": Dojo.objects.all(),
        "Ninja": Ninja.objects.all(),
    }
    return render(request, 'index.html', context)

def addDojo(request):
    Dojo.objects.create(name = request.POST['name'], city = request.POST['city'], state = request.POST['state'])
    return redirect('/')

def addNinja(request):
    Ninja.objects.create(dojo = Dojo.objects.get(id = request.POST['dojo']), first_name = request.POST['fname'], last_name = request.POST['lname'])
    return redirect('/')
# Create your views here.
