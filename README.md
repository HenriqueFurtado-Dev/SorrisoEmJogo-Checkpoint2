# Projeto: Sorriso em Jogo
O Sorriso Em Jogo é um aplicativo desenvolvido para incentivar as pessoas a registrarem seus hábitos diários de saúde bucal e a realizarem uma análise desses hábitos. Os usuários podem trocar pontos acumulados por recompensas em parcerias com dentistas afiliados à OdontoPrev. O aplicativo visa promover a saúde bucal e a conscientização sobre a importância dos cuidados diários. 

## Integrantes 
- Carlos Henrique Furtado  | RM: 553597 (Desenvolvimento dos endpoints)
- Fabíola Falcão Neris     | RM: 552715 (Diagramação e regras  de negócios)
- Rafael de Novaes         | RM: 553934 (Testes e validação)

## Rodando a aplicação
```bash
az login
```
 Crie um Grupo de Recursos
```bash
az group create --name rg-sorriso --location eastus
```
Crie uma Máquina Virtual
```bash
az vm create --resource-group rg-sorriso --name vm-sorriso --image UbuntuLTS --admin-username azureuser --generate-ssh-keys
```
Conecte-se à VM
```bash
az vm show --resource-group rg-sorriso --name vm-sorriso --show-details --query [publicIps] --output tsv
```
Conecte-se via SSH
```bash
ssh azureuser@<ENDEREÇO_IP>
```
Instale e Inicie o Docker na VM
```bash
sudo apt update
sudo apt install -y docker.io
sudo systemctl start docker
sudo systemctl enable docker
```
Clone o Repositório e Execute o Dockerfile
```bash
git clone https://github.com/HenriqueFurtado-Dev/SorrisoEmJogo_JavaAdvanced.git
cd SorrisoEmJogo_JavaAdvanced
sudo docker build -t sorriso-em-jogo .
sudo docker run -p 8080:8080 sorriso-em-jogo
```

## Link para vídeo de inserção das informações no banco:
https://www.youtube.com/watch?v=BcV4CheBA9U

## Endpoints - Um exemplo de JSON está disponível na collection do Postman
Usuários: http://localhost:8080/api/usuarios

Recompensa: http://localhost:8080/api/recompensas

Habitos: http://localhost:8080/api/habitos

Registro Habito: http://localhost:8080/api/registro-habitos

Unidades: http://localhost:8080/api/unidades

Procedimentos: http://localhost:8080/api/procedimentos


# Diagrama de Classe
![SorrisoEmJogoDiagramaClasse](https://github.com/user-attachments/assets/81a8edc4-32c8-4635-9c08-d4c7222b2d48)
