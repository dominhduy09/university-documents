clear all; clc;
%Set the edge
a=2;
b=2;
c=2;

 %set q, r, s points
q=0.9*a
r=0.6*b
s=0.6*c
Indices=[q r s]


%plot
plot3(q,r,s,'r')
grid
xlabel('x')
ylabel('y')
zlabel('z')
axis([-2 2 -2 2 -2 2])

