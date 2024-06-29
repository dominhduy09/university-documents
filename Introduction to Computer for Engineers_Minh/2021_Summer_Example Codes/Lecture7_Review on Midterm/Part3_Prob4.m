clear all; close all; clc;

% INDICATOR FUNCTIONS
x = -10:0.01:10;
y = (-x/3-2).*((x>=-6)&(x<-3)) + 1.*((x>=-3)&(x<0)) + ((-x/3)+1).*((x>=0)&(x<3));
figure
plot(x,y,'-b'); ylim([-2 2])
xlabel('t'); ylabel('x(t)');

% FOR-LOOPS
x = -10:0.01:10;
for i=1:length(x)
    if ((x(i)>=-6)&(x(i)<-3))
        f(i)=-x(i)/3 -2;
    elseif ((x(i)>=-3)&(x(i)<0))
        f(i)=1;
    elseif ((x(i)>=0)&(x(i)<3))
        f(i)=-x(i)/3+1;
    else 
        f(i)= 0;
    end
end
plot(x,f)