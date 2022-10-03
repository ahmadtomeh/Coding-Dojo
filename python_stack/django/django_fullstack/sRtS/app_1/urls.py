from django.urls import path
from . import views

urlpatterns = [
    path('shows/new', views.createShow),
    path('', views.root),
    path('shows/<int:id>', views.show_one),
    path('create', views.create),
    path('shows', views.showAll),
    path('shows/<int:id>/edit', views.edit_one),
    path('update', views.edit),
    path('delete/<int:id>', views.delete),
]