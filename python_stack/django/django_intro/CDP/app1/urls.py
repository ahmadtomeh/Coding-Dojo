from django.urls import path, include
from . import views


urlpatterns = [
    path('',views.index),
    path('<int:my_val>', views.a), 
]
