clc; clear all; close all
n = 0; S = 0;
while n > -1
    n = n + 1;
    S = S + n;           % Compute S = 1+2+3+...+n
    if (S>100)&(S<1000)  % Condition on 100 < S < 1000 
        tram = floor(S/100);  % chu so phan tram
        chuc = floor((S-tram*100)/10); % chu so phan chuc
        dvi  = S-tram*100-chuc*10;    % chu so don vi
        if (tram == chuc)&(tram == dvi)
            disp(n)
            disp(S)
        end
    else
        if S <= 100
            continue;
        else
            break;
        end
    end
end