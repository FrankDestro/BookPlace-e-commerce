
INSERT INTO tb_user (full_name, cpf, phone, birth_date, email, password, created_at, updated_at) VALUES ('Alice Oliveira', '01177856989', '11980783433', '1990-04-10', 'alice.oliveira@gmail.com', '$2a$10$BZEayVp6X1Ry93e44/Rnze0hpK5J3ThbAdUm2OzH.GSWjA4zmtGHW', NOW(), null);
INSERT INTO tb_user (full_name, cpf, phone, birth_date, email, password, created_at, updated_at) VALUES ('Marcos Santos', '34578987632', '1175908855', '1985-10-30', 'marcos.santos@gmail.com', '$2a$10$BZEayVp6X1Ry93e44/Rnze0hpK5J3ThbAdUm2OzH.GSWjA4zmtGHW', NOW(), null);

INSERT INTO role (authority) VALUES ('ROLE_ADMIN');
INSERT INTO role (authority) VALUES ('ROLE_OPERATOR');

INSERT INTO user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO user_role (user_id, role_id) VALUES (2, 2);3

-- Categoria 1: Fantasia
INSERT INTO category (name) VALUES ('Fantasia');
-- Categoria 2: Romance
INSERT INTO category (name) VALUES ('Romance');
-- Categoria 3: Clássico
INSERT INTO category (name) VALUES ('Clássico');
-- Categoria 4: Autoajuda
INSERT INTO category (name) VALUES ('Autoajuda');
-- Categoria 5: Livro Técnico
INSERT INTO category (name) VALUES ('Livro Técnico');

-- Livro 1: O Senhor dos Anéis
INSERT INTO product (name, price, cash_Price, installment_Price, description, details, created_At, updated_At, author, pages, language, publishing_company, publication_date, isbn10, isbn13, dimensions, format) VALUES ('O Senhor dos Anéis : A Sociedade do Anel', 59.90, 55.00, 12.00, 'A Sociedade do Anel começa no Condado, a região rural do oeste da Terra-média onde vivem os diminutos e pacatos hobbits. Bilbo Bolseiro, um dos raros aventureiros desse povo, cujas peripécias foram contadas em O Hobbit, resolve ir embora do Condado e deixa sua considerável herança nas mãos de seu jovem parente Frodo.', 'Capa dura, 1178 páginas.', '2024-03-25 00:00:00', '2024-03-25 00:00:00', 'J.R.R. Tolkien', 1178, 'Português', 'Editora Martins Fontes', '2000-01-01', '8578270699', '9788578270693', '16 x 3.5 x 23 cm', 'Capa dura');
INSERT INTO tb_product_image (product_id, image_url) VALUES (1, 'https://raw.githubusercontent.com/FrankDestro/bookplace-imagens/main/senhordosaneis1.jpg');
INSERT INTO tb_product_image (product_id, image_url) VALUES (1, 'https://raw.githubusercontent.com/FrankDestro/bookplace-imagens/main/senhor2.jpg');
INSERT INTO tb_product_image (product_id, image_url) VALUES (1, 'https://raw.githubusercontent.com/FrankDestro/bookplace-imagens/main/senhor3.jpg');
INSERT INTO tb_product_image (product_id, image_url) VALUES (1, 'https://raw.githubusercontent.com/FrankDestro/bookplace-imagens/main/senhor4.jpg');

-- Livro 2: Crime e Castigo
INSERT INTO product (name, price, cash_Price, installment_Price, description, details, created_At, updated_At, author, pages, language, publishing_company, publication_date, isbn10, isbn13, dimensions, format) VALUES ('Crime e Castigo', 45.00, 40.00, 10.00, '"Crime e castigo" é um daqueles romances universais que, concebidos no decorrer do romântico século XIX, abriram caminhos ao trágico realismo literário dos tempos modernos. Contando nele a soturna história de um assassino em busca de redenção e ressurreição espiritual, Dostoiévski chegou a explorar, como nenhum outro escritor de sua época, as mais diversas facetas da psicologia humana sujeita a abalos e distorções e, desse modo, criou uma obra de imenso valor artístico, merecidamente cultuada em todas as partes do mundo. O fascinante efeito que produz a leitura de "Crime e castigo" - angústia, revolta e compaixão renovadas a cada página com um desenlace aliviador - poderia ser comparado à catarse dos monumentais dramas gregos.', 'Capa comum, 608 páginas.', '2024-03-25 00:00:00', '2024-03-25 00:00:00', 'Fiódor Dostoiévski', 608, 'Português', 'Editora 34', '2018-08-01', '8573265266', '9788573265263', '20.8 x 13.8 x 3.4 cm', 'Capa comum');
INSERT INTO tb_product_image (product_id, image_url) VALUES (2, 'https://raw.githubusercontent.com/FrankDestro/bookplace-imagens/main/crime1.jpg');
INSERT INTO tb_product_image (product_id, image_url) VALUES (2, 'https://raw.githubusercontent.com/FrankDestro/bookplace-imagens/main/crime2.jpg');
INSERT INTO tb_product_image (product_id, image_url) VALUES (2, 'https://raw.githubusercontent.com/FrankDestro/bookplace-imagens/main/crime3.jpg');
INSERT INTO tb_product_image (product_id, image_url) VALUES (2, 'https://raw.githubusercontent.com/FrankDestro/bookplace-imagens/main/crime4.jpg');

-- Livro 3: A Culpa é das Estrelas
INSERT INTO product (name, price, cash_Price, installment_Price, description, details, created_At, updated_At, author, pages, language, publishing_company, publication_date, isbn10, isbn13, dimensions, format) VALUES ('A Culpa é das Estrelas', 29.99, 28.00, 7.00, 'Hazel é uma paciente terminal. Ainda que, por um milagre da medicina, seu tumor tenha encolhido bastante ― o que lhe dá a promessa de viver mais alguns anos ―, o último capítulo de sua história foi escrito no momento do diagnóstico.Mas em todo bom enredo há uma reviravolta, e a de Hazel se chama Augustus Waters, um garoto bonito que certo dia aparece no Grupo de Apoio a Crianças com Câncer. Juntos, os dois vão preencher o pequeno infinito das páginas em branco de suas vidas.Inspirador, corajoso, irreverente e brutal, A culpa é das estrelas é a obra mais ambiciosa e emocionante de John Green, sobre a alegria e a tragédia que é viver e amar.', 'Capa comum, 288 páginas.', '2024-03-25 00:00:00', '2024-03-25 00:00:00', 'John Green', 288, 'Português', 'Intrínseca', '2013-10-10', '8580572895', '9788580572897', '20.8 x 13.8 x 1.6 cm', 'Capa comum');
INSERT INTO tb_product_image (product_id, image_url) VALUES (3, 'https://raw.githubusercontent.com/FrankDestro/bookplace-imagens/main/estrela1.jpg');
INSERT INTO tb_product_image (product_id, image_url) VALUES (3, 'https://raw.githubusercontent.com/FrankDestro/bookplace-imagens/main/estrela2.jpg');
INSERT INTO tb_product_image (product_id, image_url) VALUES (3, 'https://raw.githubusercontent.com/FrankDestro/bookplace-imagens/main/estrela3.jpg');
INSERT INTO tb_product_image (product_id, image_url) VALUES (3, 'https://raw.githubusercontent.com/FrankDestro/bookplace-imagens/main/estrela4.jpg');


-- Livro 4: A Revolução dos Bichos
INSERT INTO product (name, price, cash_Price, installment_Price, description, details, created_At, updated_At, author, pages, language, publishing_company, publication_date, isbn10, isbn13, dimensions, format) VALUES ('A Revolução dos Bichos', 34.90, 32.00, 8.00, 'Verdadeiro clássico moderno, concebido por um dos mais influentes escritores do século XX, A revolução dos bichos é uma fábula sobre o poder. Narra a insurreição dos animais de uma granja contra seus donos. Progressivamente, porém, a revolução degenera numa tirania ainda mais opressiva que a dos humanos.', 'Capa comum, 152 páginas.', '2024-03-25 00:00:00', '2024-03-25 00:00:00', 'George Orwell', 152, 'Português', 'Companhia das Letras', '2007-02-26', '8535910633', '9788535910634', '20.8 x 13.6 x 1 cm', 'Capa comum');
INSERT INTO tb_product_image (product_id, image_url) VALUES (4, 'https://raw.githubusercontent.com/FrankDestro/bookplace-imagens/main/bichos1.jpg');
INSERT INTO tb_product_image (product_id, image_url) VALUES (4, 'https://raw.githubusercontent.com/FrankDestro/bookplace-imagens/main/bichos2.jpg');
INSERT INTO tb_product_image (product_id, image_url) VALUES (4, 'https://raw.githubusercontent.com/FrankDestro/bookplace-imagens/main/bichos3.jpg');


-- Livro 5: Cem Anos de Solidão
INSERT INTO product (name, price, cash_Price, installment_Price, description, details, created_At, updated_At, author, pages, language, publishing_company, publication_date, isbn10, isbn13, dimensions, format) VALUES ('Cem Anos de Solidão', 49.99, 45.00, 11.00, 'Neste clássico de Gabriel García Márquez, conheça as fabulosas aventuras dos Buendía-Iguarán, com seus milagres, fantasias e dramas que representam famílias do mundo inteiro. Romance fundamental na história da literatura, Cem anos de solidão apresenta uma das mais fascinantes aventuras literárias do século XX. Vencedora do Prêmio Nobel de Literatura, uma obra que todos devíamos ter em nossas estantes.', 'Capa comum, 448 páginas.', '2024-03-25 00:00:00', '2024-03-25 00:00:00', 'Gabriel García Márquez', 448, 'Português', 'Editora Record', '2001-06-05', '8501042219', '9788501042217', '21 x 14 x 2.6 cm', 'Capa comum');
INSERT INTO tb_product_image (product_id, image_url) VALUES (5, 'https://raw.githubusercontent.com/FrankDestro/bookplace-imagens/main/cem1.jpg');
INSERT INTO tb_product_image (product_id, image_url) VALUES (5, 'https://raw.githubusercontent.com/FrankDestro/bookplace-imagens/main/cem2.jpg');
INSERT INTO tb_product_image (product_id, image_url) VALUES (5, 'https://raw.githubusercontent.com/FrankDestro/bookplace-imagens/main/cem3.jpg');

-- Livro 6: Harry Potter e a Pedra Filosofal
INSERT INTO product (name, price, cash_Price, installment_Price, description, details, created_At, updated_At, author, pages, language, publishing_company, publication_date, isbn10, isbn13, dimensions, format) VALUES ('Harry Potter e a Pedra Filosofal', 39.90, 37.00, 9.00, 'Harry Potter é um garoto cujos pais, feiticeiros, foram assassinados por um poderosíssimo bruxo quando ele ainda era um bebê. Ele foi levado, então, para a casa dos tios que nada tinham a ver com o sobrenatural. Pelo contrário. Até os 10 anos, Harry foi uma espécie de gata borralheira: maltratado pelos tios, herdava roupas velhas do primo gorducho, tinha óculos remendados e era tratado como um estorvo. No dia de seu aniversário de 11 anos, entretanto, ele parece deslizar por um buraco sem fundo, como o de Alice no país das maravilhas, que o conduz a um mundo mágico. Descobre sua verdadeira história e seu destino: ser um aprendiz de feiticeiro até o dia em que terá que enfrentar a pior força do mal, o homem que assassinou seus pais. O menino de olhos verde, magricela e desengonçado, tão habituado à rejeição, descobre, também, que é um herói no universo dos magos. Potter fica sabendo que é a única pessoa a ter sobrevivido a um ataque do tal bruxo do mal e essa é a causa da marca em forma de raio que ele carrega na testa. Ele não é um garoto qualquer, ele sequer é um feiticeiro qualquer ele é Harry Potter, símbolo de poder, resistência e um líder natural entre os sobrenaturais. A fábula, recheada de fantasmas, paredes que falam, caldeirões, sapos, unicórnios, dragões e gigantes, não é, entretanto, apenas um passatempo.', 'Capa comum, 256 páginas.', '2024-03-25 00:00:00', '2024-03-25 00:00:00', 'J.K. Rowling', 256, 'Português', 'Rocco', '2015-08-14', '8532530800', '9788532530804', '22.8 x 15.6 x 1.4 cm', 'Capa comum');
INSERT INTO tb_product_image (product_id, image_url) VALUES (6, 'https://raw.githubusercontent.com/FrankDestro/bookplace-imagens/main/harry1.jpg');
INSERT INTO tb_product_image (product_id, image_url) VALUES (6, 'https://raw.githubusercontent.com/FrankDestro/bookplace-imagens/main/harry2.jpg');

-- Livro 7: Dom Quixote
INSERT INTO product (name, price, cash_Price, installment_Price, description, details, created_At, updated_At, author, pages, language, publishing_company, publication_date, isbn10, isbn13, dimensions, format) VALUES ('Dom Quixote', 55.00, 50.00, 10.00, 'Dom Quixote, escrito pelo espanhol Miguel de Cervantes, é um clássico da literatura mundial e uma das obras mais influentes da história. Publicado pela primeira vez em 1605, o romance é uma obra-prima da ficção que tece uma narrativa na qual humor, drama e filosofia são mesclados a personagens complexos e emocionantes. A história gira em torno de Alonso Quijano, um fidalgo empobrecido que decide se tornar um cavaleiro errante e defender os oprimidos. Vestido com uma armadura antiga, dá a si mesmo o nome de Dom Quixote e parte em busca de aventuras acompanhado por seu leal escudeiro, Sancho Pança. Enquanto narra a luta de Dom Quixote para reconciliar seus sonhos idealistas com a realidade do mundo em que vive, Cervantes traz à tona questões profundas de identidade, loucura, amor e amizade, convidando o leitor a profundas reflexões acerca do mundo e de si mesmo, além de incentivar a busca pelos sonhos e ideais, ainda que pareçam loucos aos olhos alheios. Esta edição especial traz capa dura com acabamento almofadado, conferindo um toque de elegância e durabilidade à obra. Além disso, inclui um marcador de páginas de fitilho, proporcionando aos leitores uma experiência ainda mais prazerosa. Uma obra indispensável na biblioteca de qualquer leitor.', 'Capa comum, 1088 páginas.', '2024-03-25 00:00:00', '2024-03-25 00:00:00', 'Miguel de Cervantes', 1088, 'Português', 'Nova Fronteira', '2009-04-15', '8520922629', '9788520922623', '22.6 x 15.8 x 5.4 cm', 'Capa comum');
INSERT INTO tb_product_image (product_id, image_url) VALUES (7, 'https://raw.githubusercontent.com/FrankDestro/bookplace-imagens/main/dom1.jpg');
INSERT INTO tb_product_image (product_id, image_url) VALUES (7, 'https://raw.githubusercontent.com/FrankDestro/bookplace-imagens/main/dom2.jpg');
INSERT INTO tb_product_image (product_id, image_url) VALUES (7, 'https://raw.githubusercontent.com/FrankDestro/bookplace-imagens/main/dom3.jpg');
INSERT INTO tb_product_image (product_id, image_url) VALUES (7, 'https://raw.githubusercontent.com/FrankDestro/bookplace-imagens/main/dom4.jpg');
INSERT INTO tb_product_image (product_id, image_url) VALUES (7, 'https://raw.githubusercontent.com/FrankDestro/bookplace-imagens/main/dom5.jpg');

-- Livro 8: A Metamorfose
INSERT INTO product (name, price, cash_Price, installment_Price, description, details, created_At, updated_At, author, pages, language, publishing_company, publication_date, isbn10, isbn13, dimensions, format) VALUES ('A Metamorfose', 25.00, 22.00, 6.00, 'A metamorfose (Die Verwandlung, em alemão) é uma novela escrita por Franz Kafka, publicada pela primeira vez em 1915. Nessa obra, Kafka descreve o caixeiro viajante Gregor Samsa, que abandona as suas vontades e desejos para sustentar a família e pagar a dívida dos pais. Numa certa manhã, Gregor acorda metamorfoseado num inseto monstruoso.', 'Capa comum, 104 páginas.', '2024-03-25 00:00:00', '2024-03-25 00:00:00', 'Franz Kafka', 104, 'Português', 'L&PM Editores', '2012-04-01', '8525423337', '9788525423332', '18 x 11 x 1 cm', 'Capa comum');
INSERT INTO tb_product_image (product_id, image_url) VALUES (8, 'https://raw.githubusercontent.com/FrankDestro/bookplace-imagens/main/meta1.jpg');

-- Livro 9: O Príncipe
INSERT INTO product (name, price, cash_Price, installment_Price, description, details, created_At, updated_At, author, pages, language, publishing_company, publication_date, isbn10, isbn13, dimensions, format) VALUES ('O Príncipe', 19.99, 18.00, 5.00, 'Publicado em 1532 pelo controverso e complexo filósofo Maquiavel, O Príncipe traz uma abordagem direta e desapaixonada acerca da natureza e do poder político. Neste tratado, o autor defende conceitos pragmáticos, entre os quais a ideia de um governante ser capaz de agir sem restrições morais para manter o controle de seu estado. Com base em exemplos históricos e em sua própria experiência como diplomata, Maquiavel também oferece conselhos práticos sobre como conquistar e manter o poder, reforçando, ainda, a importância de manter a lealdade do povo e dos aliados. Trata-se de um livro que oferece uma visão única e fascinante do mundo político de sua época, repleta de intrigas, conflitos e traições. Esta edição especial traz capa dura com acabamento almofadado, conferindo um toque de elegância e durabilidade à obra. Além disso, inclui um marcador de páginas de fitilho, proporcionando aos leitores uma experiência ainda mais prazerosa. Uma obra indispensável na biblioteca de qualquer leitor.', 'Capa comum, 176 páginas.', '2024-03-25 00:00:00', '2024-03-25 00:00:00', 'Nicolau Maquiavel', 176, 'Português', 'L&PM Editores', '2012-06-01', '8525412845', '9788525412848', '21 x 14 x 1 cm', 'Capa comum');
INSERT INTO tb_product_image (product_id, image_url) VALUES (9, 'https://raw.githubusercontent.com/FrankDestro/bookplace-imagens/main/prince1.jpg');
INSERT INTO tb_product_image (product_id, image_url) VALUES (9, 'https://raw.githubusercontent.com/FrankDestro/bookplace-imagens/main/prince2.jpg');
INSERT INTO tb_product_image (product_id, image_url) VALUES (9, 'https://raw.githubusercontent.com/FrankDestro/bookplace-imagens/main/prince3.jpg');
INSERT INTO tb_product_image (product_id, image_url) VALUES (9, 'https://raw.githubusercontent.com/FrankDestro/bookplace-imagens/main/prince4.jpg');
INSERT INTO tb_product_image (product_id, image_url) VALUES (9, 'https://raw.githubusercontent.com/FrankDestro/bookplace-imagens/main/prince5.jpg');

-- Livro 10: Orgulho e Preconceito
INSERT INTO product (name, price, cash_Price, installment_Price, description, details, created_At, updated_At, author, pages, language, publishing_company, publication_date, isbn10, isbn13, dimensions, format) VALUES ('Orgulho e Preconceito', 32.50, 30.00, 7.50, 'Orgulho e Preconceito é um dos mais aclamados romances da escritora inglesa Jane Austen. Publicado em 1813, revela como era a sociedade da época, quando os relacionamentos se desenrolavam de maneira mais lenta e romântica, no ritmo das cartas levadas por mensageiros a cavalo. Nesse mundo, o sonho da Sra. Bennet era casar bem suas cinco filhas: Jane, Elizabeth, Mary, Kitty e Lydia. Entre as irmãs, destaca-se Elizabeth, a Lizzy, que se depara com um turbilhão de sentimentos diante do orgulho e preconceito que mascaram a realidade. Trata-se de um clássico que, mesmo após duzentos anos desde a sua primeira publicação, continua a encantar milhões de leitores ao redor do mundo.', 'Capa comum, 432 páginas.', '2024-03-25 00:00:00', '2024-03-25 00:00:00', 'Jane Austen', 432, 'Português', 'Martin Claret', '2020-07-10', '8544002518', '9788544002514', '23 x 16 x 2.2 cm', 'Capa comum');
INSERT INTO tb_product_image (product_id, image_url) VALUES (10, 'https://raw.githubusercontent.com/FrankDestro/bookplace-imagens/main/org1.jpg');
INSERT INTO tb_product_image (product_id, image_url) VALUES (10, 'https://raw.githubusercontent.com/FrankDestro/bookplace-imagens/main/org2.jpg');
INSERT INTO tb_product_image (product_id, image_url) VALUES (10, 'https://raw.githubusercontent.com/FrankDestro/bookplace-imagens/main/org3.jpg');
INSERT INTO tb_product_image (product_id, image_url) VALUES (10, 'https://raw.githubusercontent.com/FrankDestro/bookplace-imagens/main/org4.jpg');
INSERT INTO tb_product_image (product_id, image_url) VALUES (10, 'https://raw.githubusercontent.com/FrankDestro/bookplace-imagens/main/org5.jpg');

-- Livro 11: O Poder do Hábito
INSERT INTO product (name, price, cash_Price, installment_Price, description, details, created_At, updated_At, author, pages, language, publishing_company, publication_date, isbn10, isbn13, dimensions, format) VALUES ('O Poder do Hábito', 42.00, 38.00, 9.50, 'Durante os últimos dois anos, uma jovem transformou quase todos os aspectos de sua vida. Parou de fumar, correu uma maratona e foi promovida. Em um laboratório, neurologistas descobriram que os padrões dentro do cérebro dela mudaram de maneira fundamental. Publicitários da Procter & Gamble observaram vídeos de pessoas fazendo a cama. Tentavam desesperadamente descobrir como vender um novo produto chamado Febreze, que estava prestes a se tornar um dos maiores fracassos na história da empresa. De repente, um deles detecta um padrão quase imperceptível - e, com uma sutil mudança na campanha publicitária, Febreze começa a vender um bilhão de dólares por anos. Um diretor executivo pouco conhecido assume uma das maiores empresas norte-americanas. Seu primeiro passo é atacar um único padrão entre os funcionários - a maneira como lidam com a segurança no ambiente de trabalho -, e logo a empresa começa a ter o melhor desempenho no índice Dow Jones.', 'Capa comum, 408 páginas.', '2024-03-25 00:00:00', '2024-03-25 00:00:00', 'Charles Duhigg', 408, 'Português', 'Objetiva', '2012-04-05', '8539004119', '9788539004113', '23 x 16 x 2.6 cm', 'Capa comum');
INSERT INTO tb_product_image (product_id, image_url) VALUES (11, 'https://raw.githubusercontent.com/FrankDestro/bookplace-imagens/main/habi1.jpg');
INSERT INTO tb_product_image (product_id, image_url) VALUES (11, 'https://raw.githubusercontent.com/FrankDestro/bookplace-imagens/main/hab2.jpg');
INSERT INTO tb_product_image (product_id, image_url) VALUES (11, 'https://raw.githubusercontent.com/FrankDestro/bookplace-imagens/main/hab3.jpg');

-- Livro 12: A Arte da Guerra
INSERT INTO product (name, price, cash_Price, installment_Price, description, details, created_At, updated_At, author, pages, language, publishing_company, publication_date, isbn10, isbn13, dimensions, format) VALUES ('A Arte da Guerra', 29.90, 27.00, 7.00, 'Elaborada há mais de 2500 anos, A Arte da Guerra é uma obra-prima da ciência militar cujos conceitos e ensinamentos influenciaram guerreiros da Antiguidade e continuam úteis para todos os tipos de líderes e estrategistas modernos. Um eterno best-seller entre apreciadores de estratégia política, de negócios e na vida cotidiana. Esta edição especial traz capa dura com acabamento almofadado, conferindo um toque de elegância e durabilidade à obra. Além disso, inclui um marcador de páginas de fitilho e acesso ao audiobook, proporcionando aos leitores uma experiência ainda mais prazerosa. Uma obra indispensável na biblioteca de qualquer leitor.', 'Capa comum, 128 páginas.', '2024-03-25 00:00:00', '2024-03-25 00:00:00', 'Sun Tzu', 128, 'Português', 'Martin Claret', '2017-11-01', '8544000272', '9788544000275', '18.2 x 12.2 x 1 cm', 'Capa comum');
INSERT INTO tb_product_image (product_id, image_url) VALUES (12, 'https://raw.githubusercontent.com/FrankDestro/bookplace-imagens/main/guerra1.jpg');
INSERT INTO tb_product_image (product_id, image_url) VALUES (12, 'https://raw.githubusercontent.com/FrankDestro/bookplace-imagens/main/guerra2.jpg');
INSERT INTO tb_product_image (product_id, image_url) VALUES (12, 'https://raw.githubusercontent.com/FrankDestro/bookplace-imagens/main/guerra3.jpg');
INSERT INTO tb_product_image (product_id, image_url) VALUES (12, 'https://raw.githubusercontent.com/FrankDestro/bookplace-imagens/main/guerra4.jpg');
INSERT INTO tb_product_image (product_id, image_url) VALUES (12, 'https://raw.githubusercontent.com/FrankDestro/bookplace-imagens/main/guerra5.jpg');
--INSERT INTO tb_product_image (product_id, image_url) VALUES (12, 'https://raw.githubusercontent.com/FrankDestro/bookplace-imagens/main/guerra6.jpg');

-- Livro 13: Inteligência Emocional
INSERT INTO product (name, price, cash_Price, installment_Price, description, details, created_At, updated_At, author, pages, language, publishing_company, publication_date, isbn10, isbn13, dimensions, format) VALUES ('Inteligência Emocional', 35.50, 32.00, 8.00, 'Publicado pela primeira vez em 1995, nos Estados Unidos, este livro transformou a maneira de pensar a inteligência. Alterou práticas de educação e mudou o mundo dos negócios. Das fronteiras da psicologia e da neurociência, Daniel Goleman trouxe o conceito de "duas mentes" - a racional e a emocional - e explicou como, juntas, elas moldam nosso destino. Segundo Goleman, a consciência das emoções é fator essencial para o desenvolvimento da inteligência do indivíduo. Partindo de casos cotidianos, o autor mostra como a incapacidade de lidar com as próprias emoções pode minar a experiência escolar, acabar com carreiras promissoras e destruir vidas. O fracasso e a vitória não são determinados por algum tipo de loteria genética: muitos dos circuitos cerebrais da mente humana são maleáveis e podem ser trabalhados. Utilizando exemplos marcantes, Goleman descreve as cinco habilidades-chave da inteligência emocional e mostra como elas determinam nosso êxito nos relacionamentos e no trabalho, e até nosso bem-estar físico. Pais, professores e líderes do mundo dos negócios sentirão o valor desta visão arrebatadora do potencial humano.', 'Capa comum, 384 páginas.', '2024-03-25 00:00:00', '2024-03-25 00:00:00', 'Daniel Goleman', 384, 'Português', 'Objetiva', '2017-01-02', '8539004119', '9788539004113', '23 x 16 x 2.6 cm', 'Capa comum');
INSERT INTO tb_product_image (product_id, image_url) VALUES (13, 'https://raw.githubusercontent.com/FrankDestro/bookplace-imagens/main/emocional1.jpg');
INSERT INTO tb_product_image (product_id, image_url) VALUES (13, 'https://raw.githubusercontent.com/FrankDestro/bookplace-imagens/main/emocional2.jpg');

-- Livro 14: Python para Análise de Dados
INSERT INTO product (name, price, cash_Price, installment_Price, description, details, created_At, updated_At, author, pages, language, publishing_company, publication_date, isbn10, isbn13, dimensions, format) VALUES ('Python para Análise de Dados', 55.00, 50.00, 12.00, 'Adquira o manual definitivo para manipulação, processamento, limpeza e extração de informações de conjuntos de dados em Python. Atualizada para Python 3.10 e pandas 1.4, a terceira edição deste guia dinâmico vem com estudos de casos práticos que mostram como resolver um amplo conjunto de problemas de análise de dados de maneira eficaz. Durante o processo, você conhecerá as últimas versões do pandas, NumPy e Jupyter. Escrito por Wes McKinney, o criador do projeto pandas, este livro é uma introdução prática e moderna às ferramentas de ciência de dados em Python. Ele é ideal para analistas iniciantes em Python e para programadores Python iniciantes em ciência de dados e computação científica. Arquivos de dados e materiais relacionados estão disponíveis no GitHub.', 'Capa comum, 544 páginas.', '2024-03-25 00:00:00', '2024-03-25 00:00:00', 'Wes McKinney', 544, 'Português', 'Novatec Editora', '2023-10-05', '8575228862', '9788575228864', '23 x 16 x 2.6 cm', 'Capa comum');
INSERT INTO tb_product_image (product_id, image_url) VALUES (14, 'https://raw.githubusercontent.com/FrankDestro/bookplace-imagens/main/python1.jpg');

-- Livro 15: Mindset: A Nova Psicologia do Sucesso
INSERT INTO product (name, price, cash_Price, installment_Price, description, details, created_At, updated_At, author, pages, language, publishing_company, publication_date, isbn10, isbn13, dimensions, format) VALUES ('Mindset: A Nova Psicologia do Sucesso', 39.99, 36.00, 9.00, 'Carol S. Dweck, ph.D., professora de psicologia na Universidade Stanford e especialista internacional em sucesso e motivação, desenvolveu, ao longo de décadas de pesquisa, um conceito fundamental: a atitude mental com que encaramos a vida, que ela chama de “mindset”, é crucial para o sucesso. Dweck revela de forma brilhante como o sucesso pode ser alcançado pela maneira como lidamos com nossos objetivos. O mindset não é um mero traço de personalidade, é a explicação de por que somos otimistas ou pessimistas, bem-sucedidos ou não. Ele define nossa relação com o trabalho e com as pessoas e a maneira como educamos nossos filhos. É um fator decisivo para que todo o nosso potencial seja explorado.', 'Capa comum, 320 páginas.', '2024-03-25 00:00:00', '2024-03-25 00:00:00', 'Carol S. Dweck', 320, 'Português', 'Objetiva', '2017-05-15', '8539007029', '9788539007022', '23 x 16 x 2.2 cm', 'Capa comum');
INSERT INTO tb_product_image (product_id, image_url) VALUES (15, 'https://raw.githubusercontent.com/FrankDestro/bookplace-imagens/main/psi1.jpg');
INSERT INTO tb_product_image (product_id, image_url) VALUES (15, 'https://raw.githubusercontent.com/FrankDestro/bookplace-imagens/main/psi2.jpg');
INSERT INTO tb_product_image (product_id, image_url) VALUES (15, 'https://raw.githubusercontent.com/FrankDestro/bookplace-imagens/main/psi3.jpg');

-- Livro 1: O Senhor dos Anéis (Fantasia)
INSERT INTO tb_product_category (product_id, category_id) VALUES (1, 1);

-- Livro 2: Crime e Castigo (Clássico)
INSERT INTO tb_product_category (product_id, category_id) VALUES (2, 3);

-- Livro 3: A Culpa é das Estrelas (Romance)
INSERT INTO tb_product_category (product_id, category_id) VALUES (3, 2);

-- Livro 4: A Revolução dos Bichos (Clássico)
INSERT INTO tb_product_category (product_id, category_id) VALUES (4, 3);

-- Livro 5: Cem Anos de Solidão (Clássico)
INSERT INTO tb_product_category (product_id, category_id) VALUES (5, 3);

-- Livro 6: Harry Potter e a Pedra Filosofal (Fantasia)
INSERT INTO tb_product_category (product_id, category_id) VALUES (6, 1);

-- Livro 7: Dom Quixote (Clássico)
INSERT INTO tb_product_category (product_id, category_id) VALUES (7, 3);

-- Livro 8: A Metamorfose (Clássico)
INSERT INTO tb_product_category (product_id, category_id) VALUES (8, 3);

-- Livro 9: O Príncipe (Clássico)
INSERT INTO tb_product_category (product_id, category_id) VALUES (9, 3);

-- Livro 10: Orgulho e Preconceito (Romance)
INSERT INTO tb_product_category (product_id, category_id) VALUES (10, 2);

-- Livro 11: O Poder do Hábito (Autoajuda)
INSERT INTO tb_product_category (product_id, category_id) VALUES (11, 4);

-- Livro 12: A Arte da Guerra (Livro Técnico)
INSERT INTO tb_product_category (product_id, category_id) VALUES (12, 5);

-- Livro 13: Inteligência Emocional (Autoajuda)
INSERT INTO tb_product_category (product_id, category_id) VALUES (13, 4);

-- Livro 14: Python para Análise de Dados (Livro Técnico)
INSERT INTO tb_product_category (product_id, category_id) VALUES (14, 5);

-- Livro 15: Mindset: A Nova Psicologia do Sucesso (Autoajuda)
INSERT INTO tb_product_category (product_id, category_id) VALUES (15, 4);

INSERT INTO tb_address (address, number, address_details, neighborhood, zip, main, user_id) VALUES ('AV. Noventa e nove', 355, 'Apt', 'Jardim Cem', '00090-001', true, 1);
INSERT INTO tb_address (address, number, address_details, neighborhood, zip, main, user_id) VALUES ('Rua quarenta e cinco', 100, 'Casa', 'Jardim Hursky', '08712-400', false, 1);
INSERT INTO tb_address (address, number, address_details, neighborhood, zip, main, user_id) VALUES ('Avenida Central', 500, 'Apartamento 302', 'Centro', '12345-678', true, 2);

-- INSERT DE PEDIDOS
INSERT INTO tb_order (moment, status, client_id, id_address) VALUES (TIMESTAMP WITH TIME ZONE '2022-07-25T13:00:00Z', 1, 1, 1);
INSERT INTO tb_order (moment, status, client_id, id_address) VALUES (TIMESTAMP WITH TIME ZONE '2022-07-29T15:50:00Z', 3, 2, 1);
INSERT INTO tb_order (moment, status, client_id, id_address) VALUES (TIMESTAMP WITH TIME ZONE '2022-08-03T14:20:00Z', 0, 1, 1);

INSERT INTO tb_order_item (order_id, product_id, quantity, price) VALUES (1, 1, 2, 90.5);
INSERT INTO tb_order_item (order_id, product_id, quantity, price) VALUES (1, 3, 1, 1250.0);
INSERT INTO tb_order_item (order_id, product_id, quantity, price) VALUES (2, 3, 1, 1250.0);
INSERT INTO tb_order_item (order_id, product_id, quantity, price) VALUES (3, 1, 1, 90.5);

INSERT INTO tb_method_payment(method_payment) VALUES ('PIX');
INSERT INTO tb_method_payment(method_payment) VALUES ('BOLETO');
INSERT INTO tb_method_payment(method_payment) VALUES ('CARTAOCREDITO');

INSERT INTO tb_payment (order_id, moment, status_Payment, method_Payment_id) VALUES (1, TIMESTAMP WITH TIME ZONE '2022-07-25T15:00:00Z', 0, 1);

INSERT INTO tb_pix (pix_Key, payment_id, method_payment_id) VALUES ('chavePix123', 1, 1);
