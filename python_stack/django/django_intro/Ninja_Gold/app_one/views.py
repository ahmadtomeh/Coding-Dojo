from django.shortcuts import render, redirect
import random
from time import strftime

def root(request):
    if 'amount' in request.session:
        pass
    else:
        request.session['amount']=0
    return render (request, "index.html")

def process_money(request):
    time = strftime("%B %d, %Y %H:%M %p")
    if request.POST['which']=='Quest':
        gold= random.randint(-50, 50)
        if gold < 0:    
            if 'P' in request.session:
                request.session ['P']+=[f"You failed a {request.POST['which']} and lost {gold*-1} gold. Ouch. ({time})"]
        elif gold > 0:
            if 'P' in request.session:
                request.session ['P']+=[f"You completed a {request.POST['which']} and earned {gold} gold. ({time})"]
    else:
        gold = random.randint(10, 20)
        if 'P' in request.session:
                request.session ['P']+=[f"You entered a {request.POST['which']} and earned {gold} gold.({time})"]
    request.session ['amount'] = request.session ['amount'] + gold
    return redirect('/')