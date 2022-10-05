from django.db import models
from time import strftime
import re


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

class Users(models.Model):
    first_name = models.CharField(max_length = 255, null = True)
    last_name = models.CharField(max_length = 255, null = True)
    email = models.EmailField(max_length = 255, null = True)
    password = models.CharField(max_length = 255, null = True)
    created_at = models.DateTimeField(auto_now_add = True)
    updated_at = models.DateTimeField(auto_now = True)
    objects = BlogManager()
# Create your models here.
