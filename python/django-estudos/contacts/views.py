from django.shortcuts import get_object_or_404, redirect, render
from contacts import models

# Create your views here.
def create_contact(request):
    if request.method == 'GET':
        contacts = models.Contact.objects.all()
        return render(request, 'create_contact.html', {'contacts':contacts})
    if request.method == 'POST':
        name = request.POST.get('name')
        email = request.POST.get('email')
        
        contact = models.Contact(
            name = name,
            email = email
        )
        
        contact.save()
        
        return redirect('create_contact')
    
def update_contact(request, id):
    contact = get_object_or_404(models.Contact, id=id)
    
    if request.method == 'POST':
        name = request.POST.get('name')
        email = request.POST.get('email')
        
        contact.name = name
        contact.email = email
        
        contact.save()
        return redirect('create_contact')

    return render(request, 'create_contact.html', {'contact': contact})
 
def delete_contact(request, id):
    contact = get_object_or_404(models.Contact, id=id)
    contact.delete()
    
    return redirect('create_contact')
