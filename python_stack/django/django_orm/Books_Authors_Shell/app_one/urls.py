from django.urls import path
from . import views

urlpatterns = [
    path('', views.book),
    path('addBook', views.addBook),
    path('showBook/<int:b_id>', views.showBook),
    path('addAuthor/<int:b_id>', views.addAuthor),
    path('authors', views.author),
    path('createAuthor', views.createAuthor),
    path('showAuthor/<int:a_id>', views.showAuthor),
    path('addBook/<int:a_id>', views.addBook2), 
]