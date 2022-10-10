from django.urls import path
from . import views

urlpatterns = [
    path('',views.root),
    path('reg',views.reg),
    path('dashboard',views.success),
    path('login',views.login),
    path('logout',views.logout),
    path('user/account',views.userTrees),
    path('new/tree',views.userPlant),
    path('plant',views.plant),
    path('edit/<int:id>',views.edit),
    path('show/<int:id>',views.show),
    path('update/<int:id>',views.update),
    path('delete/<int:id>',views.delete),
]