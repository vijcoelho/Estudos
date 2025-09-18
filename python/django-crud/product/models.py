import uuid

from django.db import models

class Product(models.Model):

    id = models.UUIDField(primary_key = True, default = uuid.uuid4())
    name = models.CharField(max_length = 255)
    price = models.IntegerField()

    def __str__(self):
        return (f"Product - "
                f"id: {self.id}, "
                f"name: {self.name}, "
                f"price: {self.price}, ")

