function s = sub_Part3_Prob2(x)
if x<-6
    s = 3*(x^2)-x;
elseif  -6 <= x <= 5
    s = sqrt(7-x);
else
    s = 8*x - 3;
end