function result = sub_func_Ex6(n,a)
    if n == 1
        result = 20;
    else
        result = 0.5*(sub_func_Ex6(n-1,a)+a/sub_func_Ex6(n-1,a));
    end
end