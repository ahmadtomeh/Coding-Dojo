from django.urls import path
from . import views

urlpatterns = [
    path('shows/new', views.createShow),
    path('', views.root),
    path('shows/<int:id>', views.show_one),
    path('create', views.create),
    path('shows', views.goBack),
    path('shows/<int:id>/edit', views.update_one),
    path('update', views.update),
    path('delete/<int:id>', views.delete),
]