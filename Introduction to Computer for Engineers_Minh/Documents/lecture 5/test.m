clear all
close all
clc
fano = @(x) (cos(x)-x.*exp(x/10));
y =fano(x);
a=-5;
b=5;
fano = @(x) (cos(x)-x.*exp(x/10));
y =fano(x);
for x=1:1:100;

if fano(a)*fano(b)<=0
  c=(a+b)/2;
 if fano(a)*fano(c)<=0
   b=c;
  endif
  if fano(c)*fano(b)<=0
     a=c;
 endif
     if abs(f(c))<0.01
       root find =1;
       break
       endif
     endif
 end
if (root_find =1)
  sprintf("Root is at x=%4f2\n\r",c)
elseif
  sprintf("there is not root \n\r")
endif
%plotting
plot(x,y,'r--'."linewidth",6)
if (root_find =1)
  hold on
  plot(c,fano(c),'gd',"markersize",20)
  hold on
  plot(c*ones(1,length(-8:0.001:4))
  end
