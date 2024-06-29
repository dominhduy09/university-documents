clear all
close all
clc

%plot function

x= 0:0.01:10;
% define function f(x)
fx= @(x) (x.*sin(x)+6.*e.^(-x));
interval =[0,10];
y =fx(x);
%define horizontal - x axis
y0=zeros(1,length(x));

%we divide the interval into N slice
N=1000;
increment=(10-0)/N;
xx=0:increment:10;
Sreal=log(11/12)-log(3/4);
printf("Intergration exact value is %4f2 \n",Sreal)
%define error comparing to rela value
error = 0.0001
%integration calculation
S=0;
for k=1:1:N
  S=S+0.5*increment*(fx(xx(k))+fx(xx(k+1)));
  if abs(S-Sreal) < error
    printf("Intergration Value within 0.0001 error is %4f2 \n",error,S);
    printf("Algorithm stop at %d\n",k);
    break
  endif
end
fprintf("Intergration value is %d \n",S)
plot(x,y,'b-',"linewidth",2)
hold on
plot(x,y0,'r-',"linewidth",2)
%plot the slice\
for k=1:1:length(xx)
hold on
plot([xx(k) xx(k)],[0 fx(xx(k))],'r--',"linewidth",2);
end
axis([2 10])
grid on
title('Nguyen Dao Anh Khoi - Function {tsin(t)+6*e^(-x)}')
ylabel('Function f_1(x)');
xlabel('x axis (unit 0.01 increment)');
