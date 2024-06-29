clc
function out=f(x)
  out=[0; 0];
  out(1)=f1(x);
  out(2)=exp(2*x)./(3*x+2);

end
f(1)
