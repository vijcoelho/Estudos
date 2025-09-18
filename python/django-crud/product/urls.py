from django.urls import path
from product import views

urlpatterns = [
    path('', view=views.create_product, name='create_product'),
]