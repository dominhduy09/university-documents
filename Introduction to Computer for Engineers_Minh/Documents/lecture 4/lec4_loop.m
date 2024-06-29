close all
clear all
clc

##for k=[1,2,3,4,5]
##  s1=0.1 + 3*k;
##end
##printf('s1= %d', s1)
##
##for k=1:1:5
##  s2= 0.1 + 3*k;
##  end
##printf('s2= %d\n', s2)
##
##for k=1:5
##  s3= 0.1 + 3*k;
##  end
##printf('s3= %d \n', s3)

##clear x;
## for k=[3,7,10]
##   x(k) = 3 + 0.1*k;
##   disp(x)
##end
##x = zeros(1,10);
## for k=[3,7,10]
##   x(k) = 3 + 0.1*k;
##   disp(x)
## end

##N=1000;
##S=0;
##for k= 1:N;
##  S=S+ 1/k^2;
##
##end
##printf('S= %d \n', S)
##row=4;
##col=3;
##for j=1:row
##  for i=1:col
##    A(j,i)=i+j;
##    end
##  end
##
## disp(A)
##N=100;
##k=1;
##S=0;
##while(1)
##S = S + 1/k^2;
##if k>N
##  break;
##end
##k=k+1;
##end
##printf('S= %d \n', S)
##disp("Nguyễn Đào Anh Khôi");
for col = 1:5
    for row = col:5
        fprintf('%d\t', col * row);
    end
    fprintf('\n');
end


