from django.urls import path
from . import views
urlpatterns = [
    path('',views.root),
    path('add',views.add),
    path('reset',views.reset),

]
