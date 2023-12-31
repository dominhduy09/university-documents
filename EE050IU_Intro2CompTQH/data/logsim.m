% logsim.m - simulated logistic data fitting example
% 
% S. J. Orfanidis - 440:127 - Spring 2014

% K1 = 9; r1 = 0.5; t1 = 8;
% 
% c1 = [K1,r1, t1]';
% 
% f = @(c,t) c(1)./(1 + exp(-c(2)*(t-c(3))));
% 
% t = linspace(0,18,181);
% y1 = f(c1,t);
% 
% rng(100);
% ti = (1:17) + 0.5*randn(1,17);
% ti = round(10*ti)/10; ti
% yi = f(c1,ti) + 0.3*randn(size(ti));
% yi = round(100*yi)/100;
% 
% ti = ti(1:2:end)'; yi = yi(1:2:end)';
%
%  ti     yi
% ------------
%  1.1   0.04
%  2.9   1.13
%  4.5   1.22
%  7.5   3.87
%  9.0   5.33
% 10.5   6.51
% 12.9   8.37
% 15.3   8.67
% 17.4   9.03

clear all;

f = @(c,t) c(1)./(1 + exp(-c(2)*(t-c(3))));

Y = [1.1   0.04
     2.9   1.13
     4.5   1.22
     7.5   3.87
     9.0   5.33
    10.5   6.51
    12.9   11         % 8.37  
    15.3   8.67
    17.4   9.03];

ti = Y(:,1); yi = Y(:,2);

[diff0,i0] = max(diff(yi)./diff(ti));    % initial estimates
K0 = max(yi);                       
r0 = 4*diff0/K0;
t0 = ti(i0);

c0 = [K0, r0, t0]'

c = nlinfit(ti,yi,f,c0); 

J = @(c) sum(abs(yi - f(c,ti)).^2);     % DIY approach
c2 = fminsearch(J,c0);
percent = norm(c2-c)*100/norm(c) 

K = c(1)      % estimated parameters
r = c(2)
t0 = c(3)

t = linspace(0,18,181);

figure; plot(t,f(c,t), 'b-', ti,yi,'r.',t0,K/2,'g.','markersize',18);
 
T = ['{\itK} = ',num2str(K,'%6.4f'), ',  {\itr} = ',num2str(r,'%6.4f'), ',  {\itt}_0 = ',num2str(t0,'%6.4f')];
title(T)
xlabel('{\itt}'); ylabel('{\itf}({\itt})');
xaxis(0,18,0:2:18); yaxis(-0.5,12,0:2:12);

legend(' model, {\itf}({\itt})', ' data', ' inflection, {\itt}_0', 'location','nw')

text('interpreter','latex','string',...
    '$$f(t) = \frac{K}{1+e^{-r(t-t_0)}}$$',...
    'Position',[8.9 1],'FontSize',18, ...
    'color','b', 'edgecolor',[0,0,1])

% print -depsc logsim.eps
% print -dmeta logsim.wmf

% DIY 

Y = [1.1   0.04
     2.9   1.13
     4.5   1.22
     7.5   3.87
     9.0   5.33
    10.5   6.51
    12.9  11.00       % outlier, 8.37 -> 11.00
    15.3   8.67
    17.4   9.03];

ti = Y(:,1); yi = Y(:,2);

[diff0,i0] = max(diff(yi)./diff(ti));    % initial estimates
K0 = max(yi);                       
r0 = 4*diff0/K0;
t0 = ti(i0);

c0 = [K0, r0, t0]'

J = @(c) sum(abs(yi - f(c,ti)));     % L1 criterion
c1 = fminsearch(J,c0);               

J = @(c) sum((yi - f(c,ti)).^2);     % L2 criterion
c2 = fminsearch(J,c0);

t = linspace(0,18,181);

figure; plot(t,f(c1,t), 'g-', t,f(c2,t), 'b--', ti,yi,'r.','markersize',18);
 
title('comparison of {\itL}_1 and {\itL}_2 criteria');
xlabel('{\itt}'); ylabel('{\itf}({\itt})');
xaxis(0,18,0:2:18); yaxis(-0.5,12,0:2:12);

legend(' {\itL}_1', ' {\itL}_2', ' data', 'location','nw')

text('interpreter','latex','string',...
    '$$f(t) = \frac{K}{1+e^{-r(t-t_0)}}$$',...
    'Position',[8.9 1],'FontSize',18, ...
    'color','b', 'edgecolor',[0,0,1])

text('interpreter','latex','string',...
    '$$\mbox{outlier}\rightarrow$$',...
    'Position',[8.3,11.08],'FontSize',18, ...
    'color','b')

print -depsc logsim1.eps
print -dmeta logsim1.wmf














