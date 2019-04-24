import pandas as pd
import psycopg2 as psy

excel = pd.read_excel(r'C:\Users\JonasFragosoSilvaFra\Desktop\Projeto final bd.xlsx', sheet_name='remedios')

id = excel[excel.columns[0]].tolist()
nome = excel[excel.columns[1]].tolist()
indicacao = excel[excel.columns[2]].tolist()
manha = excel[excel.columns[3]].tolist()
tarde = excel[excel.columns[4]].tolist()
noite = excel[excel.columns[5]].tolist()

inicio = 'INSERT INTO remedio Values('
final = ');'
asp = '\''
v = ','

arrayComandos = []
for i in range(len(excel.index)):
    if manha[i] == 'sim':
        bManha = 'TRUE'
    else:
        bManha = 'FALSE'
    if tarde[i] == 'sim':
        bTarde = 'TRUE'
    else:
        bTarde = 'FALSE'
    if noite[i] == 'sim':
        bNoite: str = 'TRUE'
    else:
        bNoite = 'FALSE'

    arrayComandos.append(inicio + str(id[i]) + v +
                         asp + str(nome[i]) + asp + v +
                         asp + str(indicacao[i]) + asp + v +
                         bManha + v + bTarde + v + bNoite + final)


print(*arrayComandos, sep = '\n')

con = psy.connect(host='9.13.182.49',
                  database='gerenciamentoMedicamento',
                  user='postgres', password='ibm01bdc')

cur = con.cursor()

for comando in arrayComandos:
    cur.execute(comando)
    con.commit()
con.close()