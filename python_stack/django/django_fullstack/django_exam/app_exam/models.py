from django.db import models
from time import strftime
import re
from tkinter import CASCADE


class BlogManager(models.Manager):
    def basic_validator(self, postData):
        errors = {}
        # add keys and values to errors dictionary for each invalid field
        if len(postData['fname']) < 2 :
            errors["fname"] = "First name should be at least 2 characters"
        if len(postData['lname']) < 2:
            errors["lname"] = "Last name should be at least 2 characters"
        EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')
        if not EMAIL_REGEX.match(postData['email']):    # test whether a field matches the pattern            
            errors['email'] = "Invalid email address!"
        if len(postData['pass']) < 8 :
            errors["pass"] = "Password should be at least 8 characters"
        if (postData['pass']) != (postData['cpass']):
            errors["pass"] = "Please check your password"
        return errors
    
class LogManager(models.Manager):
    def basic_validator(self, postData):
        errors = {}
        # add keys and values to errors dictionary for each invalid field
        EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')
        if not EMAIL_REGEX.match(postData['email2']):    # test whether a field matches the pattern            
            errors['email2'] = "Invalid email address!"
        if len(postData['pass2']) < 8 :
            errors["pass2"] = "Password should be at least 8 characters"
        if (postData['pass2']) != (postData['cpass']):
            errors["pass2"] = "Please check your password"
        return errors
    
class TreesManager(models.Manager):
    def basic_validator(self, postData):
        errors = {}
        # add keys and values to errors dictionary for each invalid field
        if len(postData['species']) < 5 :
            errors["species"] = "species should be at least 5 characters"
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
        if len(postData['location']) < 2:
            errors["location"] = "Location should be at least 2 characters"
        if len(postData['reason']) > 50:
                errors["reason"] = "Reason Max 50 characters"
        return errors

class Users(models.Model):
    first_name = models.CharField(max_length = 255, null = True)
    last_name = models.CharField(max_length = 255, null = True)
    email = models.EmailField(max_length = 255, null = True)
    password = models.CharField(max_length = 255, null = True)
    created_at = models.DateTimeField(auto_now_add = True)
    updated_at = models.DateTimeField(auto_now = True)
    objects = BlogManager()
    
class Trees(models.Model):
    species=models.CharField(max_length=255,null=True)
    location=models.CharField(max_length=255,null=True)
    reason=models.CharField(max_length=255,null=True)
    date=models.DateField(blank = True)
    created_at=models.DateField(auto_now_add=True)
    updated_at=models.DateTimeField(auto_now=True,null=True)
    planted_by=models.ForeignKey(Users,related_name='planted',on_delete=CASCADE,null=True)
    objects = TreesManager()

# Create your models here.
