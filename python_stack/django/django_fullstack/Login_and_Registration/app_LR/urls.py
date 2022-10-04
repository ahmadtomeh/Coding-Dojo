from django.urls import path
from . import views

urlpatterns = [
    path('',views.root),
    path('reg',views.reg),
    path('success',views.success),
    path('login',views.login),
    path('logout',views.logout),
]