% Copyright 2017 Dominik Kaaser, Peter Kling, and others.
%
% Permission is hereby granted, free of charge, to any person obtaining a copy
% of this software and associated documentation files (the "Software"), to deal
% in the Software without restriction, including without limitation the rights
% to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
% copies of the Software, and to permit persons to whom the Software is
% furnished to do so, subject to the following conditions:
%
% The above copyright notice and this permission notice shall be included in all
% copies or substantial portions of the Software.
%
% THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
% IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
% FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
% AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
% LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
% OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
% SOFTWARE.

% modified 2020 for the use by students of AD

\NeedsTeXFormat{LaTeX2e}
\ProvidesClass{adtexsheet}[2020/04/27 v1.1 Exercise Sheet Class]

\RequirePackage{kvoptions}

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% class option processing
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
\SetupKeyvalOptions{
	family = AD,
	prefix = AD@
}

% load base class options and pass unknown options to base class
\PassOptionsToClass{}{scrartcl}
\PassOptionsToPackage{headlines=3}{typearea}
\DeclareDefaultOption{\PassOptionsToClass{\CurrentOption}{scrartcl}}

% process and load base class
%\ProcessKeyvalOptions*
\LoadClass{scrartcl}

% komasetup
\addtokomafont{disposition}{\rmfamily}

% load required packages
\PassOptionsToPackage{utf8}{inputenc}
\RequirePackage{inputenc}
\RequirePackage{exsheets}
\RequirePackage{multicol}
\RequirePackage{babel}
\RequirePackage{amsmath}
\RequirePackage{amssymb}
\RequirePackage{amsthm}
\RequirePackage{caption}
\RequirePackage{scrtime}
% list configuration
\PassOptionsToPackage{inline}{enumitem}
\RequirePackage{enumitem}
\setlist[enumerate,1]{label=(\alph*)}
\setlist[enumerate,2]{label=(\roman*)}
\RequirePackage{subcaption}
\RequirePackage{geometry}
\geometry{top=2cm, bottom=2cm, left=1cm, right=1cm}

% show solutions
\def\sol#1{}
\SetupExSheets{solution/print = true}
\def\sol#1{#1}

\SetupExSheets{
	headings = block-subtitle
}

%language
\newcommand*{\ADtitle}{Algorithmen und Datenstrukturen}
\newcommand*{\ADsheet}{Sheet}
\newcommand*{\ADgroup}{exercise group}
\newcommand*{\ADauthor}{Name}
\providecaptionname{ngerman}{\ADtitle}{Algorithmen und Datenstrukturen}
\providecaptionname{ngerman}{\ADsheet}{Blatt}
\providecaptionname{ngerman}{\ADgroup}{Übungsgruppe}
\providecaptionname{ngerman}{\ADgroup}{Name}

% title/header information providers
\newcommand*\@exnumber{}
\newcommand*\exnumber[1]{\renewcommand*\@exnumber#1}
\newcommand*\@participantOne{}
\newcommand*\@participantTwo{}
\newcommand*\@participantThree{}
\newcommand*\@participantFour{}
\newcommand*\participantOne[1]{\renewcommand*{\@participantOne}{#1}}
\newcommand*\participantTwo[1]{\renewcommand*{\@participantTwo}{#1}}
\newcommand*\participantThree[1]{\renewcommand*{\@participantThree}{#1}}
\newcommand*\participantFour[1]{\renewcommand*{\@participantFour}{#1}}
%\newcommand*{\@participants}{
%	\begin{tabular}{|l|c|c|c|c|c|c|c|}
%		\hline 
%		\ADauthor & \ADgroup & 1 & 2 & 3 & 4 & 5 & 6\\ 
%		\hline 
%		\@participantOne\\
%		\hline 
%		\@participantTwo\\
%		\hline 
%		\@participantThree\\
%		\hline 
%		\@participantFour\\
%		\hline 
%	\end{tabular}
%}
\newcommand*{\@participants}{
	\begin{tabular}{|l|c|c|c|c|c|c|c|}
		\hline 
		\ADauthor & \ADgroup & 1 & 2 & 3 & 4 & 5\\ 
		\hline 
		\@participantOne\\
		\hline 
		\@participantTwo\\
		\hline 
		\@participantThree\\
		\hline 
		\@participantFour\\
		\hline 
	\end{tabular}
}

% pagestyle for titlepage
\RequirePackage{scrlayer-scrpage}
\deftriplepagestyle{titlepage}
{{\titlefont\large \ADtitle}}{{\large \ADsheet~\@exnumber}}{}{}{\pagemark}{}
\ihead{Blatt \@exnumber \headmark}% Inner header

% maketitle configuration
\renewcommand{\@maketitle}{%\null
	\begin{center}
	
	\end{center} 
	{\small \@participants}
	\vskip 2em}

\AtBeginDocument{
	\maketitle
	\thispagestyle{titlepage}
}

% try to keep figure and table floats where they were defined
\renewcommand{\fps@figure}{!ht}
\renewcommand{\fps@table}{!ht}
