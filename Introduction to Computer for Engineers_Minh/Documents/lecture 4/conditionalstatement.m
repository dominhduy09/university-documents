close all
clear all
clc


##if rem(a,2)==0
##disp("a is even");
##else disp("a is odd");
##end
a=1
b=-4
c=3
delta = b^2 -4*a*c
if delta<0
  disp("no root");
elseif  delta==0
  x=-b/2*a
  disp(x);
else
 x1=((-b)+ sqrt(delta)) ./ 2*a
 x2=((-b)- sqrt(delta)) ./ 2*a

  end
disp("Nguyễn Đào Anh Khôi")
