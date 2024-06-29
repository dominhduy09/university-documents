
function tip = calc_tip (bill)

  if (bill <= 10)
      tip = 1.80;
  elseif (bill <= 60)
      tip = bill * 0.15;
  else
      tip = bill * 0.20;
  endif

   disp('Tip amount is: ');
   disp(tip);
endfunction


