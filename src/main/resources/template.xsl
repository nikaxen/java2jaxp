<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="2.0">
   <!-- Пункт №4 - указываем метода вывода - HTML -->
   <xsl:output method="html" encoding="UTF-8" version="5.2" indent="yes" />
   <xsl:template match="/">
      <html>
         <!--Пункт №1 - вызываем именованный шаблон -->
         <xsl:call-template name="head" />
         <body>
            <table>
               <thead>
                  <tr>
                     <td>N</td>
                     <td>ID</td>
                     <td>carAdvName</td>
                     <td>carAdvDate</td>
                     <td>Статус</td>
                     <td>Документы</td>
                     <td>Доступность</td>
                  </tr>
               </thead>
               <tbody>
                  <!--Пункт №2 - использование цикла - for -->
                  <xsl:for-each select="exclusiveCarAdvList/exclusiveCarAdv">
                     <!--Пункт №3 - использование сортировки по убыванию и по полю status -->
                     <xsl:sort select="id" order="descending"/>
                     <tr>
                        <!--Пункт №3 - использование нумерации с помощью функции position() -->
                        <td><xsl:number value="position()" format="1"/></td>
                        <td><xsl:value-of select="id"/></td>
                        <td><xsl:value-of select="carAdvName"/></td>
                        <td><xsl:value-of select="carAdvStatus"/></td>
                        <td><xsl:value-of select="carAdvDate"/></td>
                        <td>
                           <xsl:value-of select="ownersDocumentsList">
                              <xsl:value-of select="inn"/>
                              <xsl:value-of select="passport"/>
                           </xsl:value-of>
                        </td>
                        <td>
                           <!--Пункт №2 - использование ветвления - choose -->
                           <xsl:choose>
                              <xsl:when test="carAdvStatus = 'ACTIVE'">
                                 Активно
                              </xsl:when>
                              <xsl:otherwise>
                                 Не активно
                              </xsl:otherwise>
                           </xsl:choose>
                        </td>
                     </tr>
                  </xsl:for-each>
               </tbody>
               <tfoot>
                  <tr>
                     <td>Итого:</td>
                     <td><xsl:value-of select="count(exclusiveCarAdvList/exclusiveCarAdv)"/></td>
                  </tr>
               </tfoot>
            </table>
         </body>
      </html>
   </xsl:template>

   <!--Пункт №1 - объявляем именованный шаблон -->
   <xsl:template name="head">
      <head>
         <link rel="stylesheet" href="main.css"/>
      </head>
   </xsl:template>
</xsl:stylesheet>
