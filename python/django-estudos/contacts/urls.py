from django.contrib import admin
from django.urls import path
from contacts import views

urlpatterns = [
    path('create_contact/', view=views.create_contact, name='create_contact'),
    path('update_contact/<int:id>', view=views.update_contact, name='update_contact'),
    path('delete_contact/<int:id>', view=views.delete_contact, name='delete_contact')
]