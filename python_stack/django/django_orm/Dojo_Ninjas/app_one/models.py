from pydoc import describe
from django.db import models

class Dojo(models.Model):
    name = models.CharField(max_length=55)
    city = models.CharField(max_length=55)
    state = models.CharField(max_length=55)
    desc = models.CharField(max_length=55, default="New dojo")
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
class Ninja(models.Model):
    dojo = models.ForeignKey(Dojo, related_name="dojos", on_delete = models.CASCADE)
    first_name = models.CharField(max_length=55)
    last_name = models.CharField(max_length=55)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)



# Create your models here.
