from django.shortcuts import render

# Create your views here.
def index(request):
    return render(request, 'app/index.html')
def iniciarsesion(request):
    return render(request, 'app/iniciar.html')
def registrar(request):
    return render(request, 'app/crearCuenta.html')
def instr1(request):
    return render(request, 'app/instr1.html')
def instr2(request):
    return render(request, 'app/instr2.html')
def instr3(request):
    return render(request, 'app/instr3.html')
def instr4(request):
    return render(request, 'app/instr4.html')