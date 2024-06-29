% Code 3 Q_4

clc , clear, close all

a = input('Enter a: ');
b = input('Enter b: ');
c = input('Enter c: ');

alpha = input('Enter alpha: ');
beta = input('Enter beta: ');

syms x
f_x = a*x^2 + b*x + c;
in1 = int(f_x,alpha,beta)
fprintf('Solution for integral using symbolic is: %.3f', double(in1));

subplot(2,1,1)
fplot(x1,double(subs(f_x,x1)), 'c--', 'linewidth', 1.25)
grid on
xlabel('x')
ylabel('f_x')
whitebg('black')
