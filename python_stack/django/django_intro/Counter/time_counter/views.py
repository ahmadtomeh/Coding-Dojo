
from django.shortcuts import render , redirect

# Create your views here.

def root(request):
    if 'count' in request.session:
        request.session ['count'] += 1
    else:  
        request.session ['count'] = 1
    context= {
        'counter': request.session ['count']
    }    
    return render (request, "index.html",context)    


    
def add(request):
    request.session ['count'] += 1
    print( 'count' )
    return redirect('/')

def reset(request):
    request.session ['count']=0	
    print( 'count' )
    return redirect('/')
