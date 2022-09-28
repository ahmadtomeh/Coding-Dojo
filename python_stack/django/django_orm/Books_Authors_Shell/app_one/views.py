from django.shortcuts import render, redirect
from . models import Book, Author
def book(request):
    context = {
        "all_the_books": Book.objects.all()
    }
    return render(request, 'index.html', context)

def addBook(request):
    Book.objects.create(title = request.POST['title'], desc = request.POST['desc'])
    return redirect('/')

def showBook(request, b_id):
    context = {
        "one_book": Book.objects.get(id = b_id),
        "all_the_authors": Author.objects.all(),
        # "book_author": Book.objects.get(id= b_id).authors(Book.objects.get(id=3).authors.first())
    }
    return render(request, 'index2.html', context)

def addAuthor(request,b_id):
    Author.objects.get(id = request.POST['author']).books.add(Book.objects.get(id=b_id))
    return redirect('/showBook/'+str(b_id))

''' xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx'''

def author(request):
    context = {
        "all_the_authors": Author.objects.all(),
    }
    return render(request, 'author.html', context)
    
def createAuthor(request):
    Author.objects.create(first_name = request.POST['fname'], last_name = request.POST['lname'], notes = request.POST['notes'])
    return redirect('/authors')

def showAuthor(request, a_id):
    context = {
        "one_author": Author.objects.get(id = a_id),
        "all_the_books": Book.objects.all(),
        # "book_author": Book.objects.get(id= b_id).authors(Book.objects.get(id=3).authors.first())
    }
    return render(request, 'author2.html', context)

def addBook2(request,a_id):
    Author.objects.get(id=a_id).books.add(Book.objects.get(id = request.POST['books']))
    return redirect('/showAuthor/'+ str(a_id))
# Create your views here.
