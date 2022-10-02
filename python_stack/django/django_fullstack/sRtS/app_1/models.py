from django.db import models

class Show(models.Model):
    title = models.CharField(max_length = 45, null = True)
    network = models.CharField(max_length = 55, null = True)
    date = models.DateField(blank = True, null=True)
    desc = models.TextField(max_length=255, null = True)
    created_at = models.DateTimeField(auto_now_add = True)
    updated_at = models.DateTimeField(auto_now = True)

# Create your models here.
