
from django.db import models
from time import strftime


class BlogManager(models.Manager):
    def basic_validator(self, postData):
        errors = {}
        # add keys and values to errors dictionary for each invalid field
        if len(postData['title']) < 2 :
            errors["title"] = "show name should be at least 2 characters"
        x=postData['date']
        y1=0
        m=0
        d=0
        if x:
            y=(x[0:4])
            y1=x[0]+x[1]+x[2]+x[3]
            m=x[5]+x[6]
            d=x[8]+x[9]
        if not x:
            errors["date"] = "The date must be entered in the date field"
        if  int(y1)> int(strftime ("%Y")):
            errors["date"] = "date description should be at least 10 characters"
        if int(m)> int(strftime ("%m")):
            errors["date"] = "date description should be at least 10 characters"
        if int(d)>int(strftime ("%d")):
                errors["date"] = "invalid date "    
        if len(postData['net']) < 3:
            errors["net"] = "show network should be at least 3 characters"
        if len(postData['desc']) > 0 and len(postData['desc']) < 10:
                errors["desc"] = "show description should be at least 10 characters"
        return errors

class Show(models.Model):
    title = models.CharField(max_length = 45, null = True, unique = True)
    network = models.CharField(max_length = 55, null = True)
    date = models.DateField(blank = True)
    desc = models.TextField(max_length=255, null = True)
    created_at = models.DateTimeField(auto_now_add = True)
    updated_at = models.DateTimeField(auto_now = True)
    objects = BlogManager()
    

# Create your models here.
