from django.shortcuts import render, redirect
import random


def index(request):
    request.session['x'] = 5
    request.session['rand'] = random.randint(1, 100)
    return render(request, 'index.html')


def input(request):
    request.session['x'] -= 1
    input = int(request.POST['input'])
    p = ''
    if input == request.session['rand']:
        p = ' Was The Number!'
    elif input - 10 > request.session['rand']:
        p = 'Too hight'
    elif input + 10 < request.session['rand']:
        p = 'Too low'
    elif input > request.session['rand']:
        p = 'hight'
    elif input < request.session['rand']:
        p = 'low'
    context = {
        "p1": p,
        "input": input,
    }
    return render(request, 'index.html', context)


def reset(request):
    return redirect('/')
# Create your views here.
