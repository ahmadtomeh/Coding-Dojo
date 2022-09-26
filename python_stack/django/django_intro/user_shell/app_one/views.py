from django.shortcuts import render, redirect
# other imports
from .models import User
# show all of the data from a table
def index(request):
    context = {
        "all_the_users": User.objects.all()
    }
    return render(request, "UserswithTemplates.html", context)

def add(request):
    User.objects.create(first_name = request.POST['fname'], last_name = request.POST['lname'], email_address = request.POST['email'], age = request.POST['age'])
    return redirect( '/')



# Create your views here.
