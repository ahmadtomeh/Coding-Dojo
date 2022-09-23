
from django.shortcuts import render
import random

def index(request):

    request.session ['rand'] = random.randint(1, 100)
    
    return render(request, 'index.html')
    
def input (request):
    p=''
    input = int(request.POST['input'])
    if input == request.session['rand']:
        p = 'correct'
    elif input >  request.session['rand']:
        p = 'hight'
    elif input < request.session['rand']:
        p = 'low'
    context = {
        "p1": p,
        "num":input
    }
    return render(request, 'index.html', context)
# Create your views here.
