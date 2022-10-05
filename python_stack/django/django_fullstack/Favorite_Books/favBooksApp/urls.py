from django.urls import path
from . import views

urlpatterns = [
    path('',views.root),
    path('reg',views.reg),
    path('books',views.success),
    path('login',views.login),
    path('logout',views.logout),
    path('addb',views.addBook),
    path('favBook/<int:id>',views.addFavBook1),
    path('books/<int:id>',views.FavBook),
    path('un/<int:id>',views.unFavBook),
    path('add/<int:id>',views.addFavBook),
    path('update/<int:id>',views.update),
    path('delete/<int:id>',views.delete),
    
]
