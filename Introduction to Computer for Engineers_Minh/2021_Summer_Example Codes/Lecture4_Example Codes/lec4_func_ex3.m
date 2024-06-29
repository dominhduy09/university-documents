function result = lec4_func_ex3(N)
   k_vec = 0:N;
   x_vec = ((-1/3).^k_vec)./(2*k_vec+1);
   result = 2*sqrt(3)*cumsum(x_vec);
end