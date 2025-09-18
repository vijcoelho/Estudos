from django.shortcuts import render
from product import models

def create_product(request):
    if request.method == 'POST':
        name = request.POST.get('name')
        price = request.POST.get('price')

        product = models.Product(name = name, price = price)

        product.save()

        return render(request, "product/create_product.html", {"success": True})

    return render(request, "product/create_product.html")