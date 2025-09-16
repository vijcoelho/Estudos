from django.contrib import admin

# Register your models here.
from contacts import models

@admin.register(models.Contact)
class ContactAdmin(admin.ModelAdmin):
    list_display = 'id', 'name', 'email'