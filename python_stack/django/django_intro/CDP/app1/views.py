from django.shortcuts import render,HttpResponse
def index(request):
    return HttpResponse('drfdertdrt')
def a(request,my_val):
    return HttpResponse('drfdertdrt','{my_val}')



# Create your views here.
