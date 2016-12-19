package helper;

/**
 * Created by 15160046 on 07/11/2016.
 */
public class FakeHttpRequest extends HttpRequest {
    @Override
    public String getJson(String urlString) {
        return  "{'cidade':'Sao Paulo - SP','agora':{'data_hora':'16\\/03\\/2016 - 12:59','descricao':'Muito Nublado (dia)','temperatura':'25','umidade':'65%','visibilidade':'9,99 km','vento_velocidade':'19,31 km\\/h','vento_direcao':'SSE','pressao':'1.015,92 mBar','pressao_status':'caindo','nascer_do_sol':'6:08 am','por_do_sol':'6:19 pm','imagem':'http:\\/\\/developers.agenciaideias.com.br\\/images\\/tempo\\/28.png'},'previsoes':[{'data':'Quarta - 16\\/03\\/2016','descricao':'Trovoadas','temperatura_max':'25','temperatura_min':'18','imagem':'http:\\/\\/developers.agenciaideias.com.br\\/images\\/tempo\\/4.png'},{'data':'Quinta - 17\\/03\\/2016','descricao':'Trovoadas Dispersas','temperatura_max':'28','temperatura_min':'18','imagem':'http:\\/\\/developers.agenciaideias.com.br\\/images\\/tempo\\/38.png'},{'data':'Sexta - 18\\/03\\/2016','descricao':'Trovoadas Dispersas','temperatura_max':'28','temperatura_min':'18','imagem':'http:\\/\\/developers.agenciaideias.com.br\\/images\\/tempo\\/38.png'},{'data':'S\\u00e1bado - 19\\/03\\/2016','descricao':'Parcialmente Nublado (dia)','temperatura_max':'31','temperatura_min':'18','imagem':'http:\\/\\/developers.agenciaideias.com.br\\/images\\/tempo\\/30.png'},{'data':'Domingo - 20\\/03\\/2016','descricao':'Parcialmente Nublado (dia)','temperatura_max':'31','temperatura_min':'18','imagem':'http:\\/\\/developers.agenciaideias.com.br\\/images\\/tempo\\/30.png'}]}";
    }
}
