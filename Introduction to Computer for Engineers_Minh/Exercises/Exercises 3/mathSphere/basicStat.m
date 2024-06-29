function [mymean , myvar , mystd] = basicStat (darray)
  N = length(darray);

  mymean = sum(darray) / N;
  myvar = 0;

  for i=1:N
    myvar = myvar + (darray(i)-mymean)^2;
  endfor
  myvar = myvar / N;
  mystd = sqrt(myvar);
endfunction
