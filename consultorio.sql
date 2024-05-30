PGDMP                      |            consultorio    16.3    16.3 3               0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    24614    consultorio    DATABASE     ~   CREATE DATABASE consultorio WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Spanish_Spain.1252';
    DROP DATABASE consultorio;
                postgres    false            �            1259    24623    citas    TABLE     �   CREATE TABLE public.citas (
    "idCita" integer NOT NULL,
    fecha date NOT NULL,
    hora time without time zone NOT NULL,
    "descripción" text NOT NULL,
    extra text,
    "idPaciente" integer NOT NULL,
    "idUsuario" integer NOT NULL
);
    DROP TABLE public.citas;
       public         heap    postgres    false            �            1259    24622    citas_idCita_seq    SEQUENCE     �   CREATE SEQUENCE public."citas_idCita_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public."citas_idCita_seq";
       public          postgres    false    216                       0    0    citas_idCita_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public."citas_idCita_seq" OWNED BY public.citas."idCita";
          public          postgres    false    215            �            1259    24632    expedienteMedico    TABLE     �   CREATE TABLE public."expedienteMedico" (
    "idExpediente" integer NOT NULL,
    alergias text[],
    operaciones text[],
    "medicamentoActual" text[],
    padecimientos text[],
    "idPaciente" integer NOT NULL,
    "idUsuario" integer NOT NULL
);
 &   DROP TABLE public."expedienteMedico";
       public         heap    postgres    false            �            1259    24631 !   expedienteMedico_idExpediente_seq    SEQUENCE     �   CREATE SEQUENCE public."expedienteMedico_idExpediente_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 :   DROP SEQUENCE public."expedienteMedico_idExpediente_seq";
       public          postgres    false    218                       0    0 !   expedienteMedico_idExpediente_seq    SEQUENCE OWNED BY     m   ALTER SEQUENCE public."expedienteMedico_idExpediente_seq" OWNED BY public."expedienteMedico"."idExpediente";
          public          postgres    false    217            �            1259    24641    paciente    TABLE     �  CREATE TABLE public.paciente (
    "idPaciente" integer NOT NULL,
    nombre character varying(20) NOT NULL,
    apellidos character varying(20) NOT NULL,
    "teléfono" character varying(10) NOT NULL,
    curp character varying(18) NOT NULL,
    "fechaNac" date NOT NULL,
    "estadoCivil" character varying(10) NOT NULL,
    correo character varying(20)[] NOT NULL,
    "fechaAlta" date NOT NULL
);
    DROP TABLE public.paciente;
       public         heap    postgres    false            �            1259    24640    paciente_idPaciente_seq    SEQUENCE     �   CREATE SEQUENCE public."paciente_idPaciente_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public."paciente_idPaciente_seq";
       public          postgres    false    220                       0    0    paciente_idPaciente_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public."paciente_idPaciente_seq" OWNED BY public.paciente."idPaciente";
          public          postgres    false    219            �            1259    24701    rol    TABLE     \   CREATE TABLE public.rol (
    "idRol" integer NOT NULL,
    "descripción" text NOT NULL
);
    DROP TABLE public.rol;
       public         heap    postgres    false            �            1259    24700    rol_idRol_seq    SEQUENCE     �   CREATE SEQUENCE public."rol_idRol_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public."rol_idRol_seq";
       public          postgres    false    222                        0    0    rol_idRol_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public."rol_idRol_seq" OWNED BY public.rol."idRol";
          public          postgres    false    221            �            1259    24711    usuario    TABLE     Z  CREATE TABLE public.usuario (
    "idUsuario" integer NOT NULL,
    "idRol" integer NOT NULL,
    nombre character varying(200) NOT NULL,
    tipo character varying(20) NOT NULL,
    telefono character varying(10) NOT NULL,
    rfc character varying(13) NOT NULL,
    correo character varying(50) NOT NULL,
    contrasena character varying(6)
);
    DROP TABLE public.usuario;
       public         heap    postgres    false            �            1259    24710    usuario_idRol_seq    SEQUENCE     �   CREATE SEQUENCE public."usuario_idRol_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public."usuario_idRol_seq";
       public          postgres    false    225            !           0    0    usuario_idRol_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public."usuario_idRol_seq" OWNED BY public.usuario."idRol";
          public          postgres    false    224            �            1259    24709    usuario_idUsuario_seq    SEQUENCE     �   CREATE SEQUENCE public."usuario_idUsuario_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public."usuario_idUsuario_seq";
       public          postgres    false    225            "           0    0    usuario_idUsuario_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public."usuario_idUsuario_seq" OWNED BY public.usuario."idUsuario";
          public          postgres    false    223            e           2604    24635    expedienteMedico idExpediente    DEFAULT     �   ALTER TABLE ONLY public."expedienteMedico" ALTER COLUMN "idExpediente" SET DEFAULT nextval('public."expedienteMedico_idExpediente_seq"'::regclass);
 P   ALTER TABLE public."expedienteMedico" ALTER COLUMN "idExpediente" DROP DEFAULT;
       public          postgres    false    217    218    218            f           2604    24644    paciente idPaciente    DEFAULT     ~   ALTER TABLE ONLY public.paciente ALTER COLUMN "idPaciente" SET DEFAULT nextval('public."paciente_idPaciente_seq"'::regclass);
 D   ALTER TABLE public.paciente ALTER COLUMN "idPaciente" DROP DEFAULT;
       public          postgres    false    220    219    220            g           2604    24704 	   rol idRol    DEFAULT     j   ALTER TABLE ONLY public.rol ALTER COLUMN "idRol" SET DEFAULT nextval('public."rol_idRol_seq"'::regclass);
 :   ALTER TABLE public.rol ALTER COLUMN "idRol" DROP DEFAULT;
       public          postgres    false    222    221    222            h           2604    24714    usuario idUsuario    DEFAULT     z   ALTER TABLE ONLY public.usuario ALTER COLUMN "idUsuario" SET DEFAULT nextval('public."usuario_idUsuario_seq"'::regclass);
 B   ALTER TABLE public.usuario ALTER COLUMN "idUsuario" DROP DEFAULT;
       public          postgres    false    225    223    225            i           2604    24715    usuario idRol    DEFAULT     r   ALTER TABLE ONLY public.usuario ALTER COLUMN "idRol" SET DEFAULT nextval('public."usuario_idRol_seq"'::regclass);
 >   ALTER TABLE public.usuario ALTER COLUMN "idRol" DROP DEFAULT;
       public          postgres    false    225    224    225                      0    24623    citas 
   TABLE DATA           h   COPY public.citas ("idCita", fecha, hora, "descripción", extra, "idPaciente", "idUsuario") FROM stdin;
    public          postgres    false    216   �=                 0    24632    expedienteMedico 
   TABLE DATA           �   COPY public."expedienteMedico" ("idExpediente", alergias, operaciones, "medicamentoActual", padecimientos, "idPaciente", "idUsuario") FROM stdin;
    public          postgres    false    218   �=                 0    24641    paciente 
   TABLE DATA           �   COPY public.paciente ("idPaciente", nombre, apellidos, "teléfono", curp, "fechaNac", "estadoCivil", correo, "fechaAlta") FROM stdin;
    public          postgres    false    220   �=                 0    24701    rol 
   TABLE DATA           6   COPY public.rol ("idRol", "descripción") FROM stdin;
    public          postgres    false    222   �=                 0    24711    usuario 
   TABLE DATA           h   COPY public.usuario ("idUsuario", "idRol", nombre, tipo, telefono, rfc, correo, contrasena) FROM stdin;
    public          postgres    false    225   >       #           0    0    citas_idCita_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public."citas_idCita_seq"', 1, false);
          public          postgres    false    215            $           0    0 !   expedienteMedico_idExpediente_seq    SEQUENCE SET     R   SELECT pg_catalog.setval('public."expedienteMedico_idExpediente_seq"', 1, false);
          public          postgres    false    217            %           0    0    paciente_idPaciente_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public."paciente_idPaciente_seq"', 1, false);
          public          postgres    false    219            &           0    0    rol_idRol_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public."rol_idRol_seq"', 3, true);
          public          postgres    false    221            '           0    0    usuario_idRol_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public."usuario_idRol_seq"', 1, false);
          public          postgres    false    224            (           0    0    usuario_idUsuario_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public."usuario_idUsuario_seq"', 1, false);
          public          postgres    false    223            k           2606    24630    citas citas_idCita_pk 
   CONSTRAINT     [   ALTER TABLE ONLY public.citas
    ADD CONSTRAINT "citas_idCita_pk" PRIMARY KEY ("idCita");
 A   ALTER TABLE ONLY public.citas DROP CONSTRAINT "citas_idCita_pk";
       public            postgres    false    216            o           2606    24639 1   expedienteMedico expedienteMedico_idExpediente_pk 
   CONSTRAINT        ALTER TABLE ONLY public."expedienteMedico"
    ADD CONSTRAINT "expedienteMedico_idExpediente_pk" PRIMARY KEY ("idExpediente");
 _   ALTER TABLE ONLY public."expedienteMedico" DROP CONSTRAINT "expedienteMedico_idExpediente_pk";
       public            postgres    false    218            s           2606    24648    paciente paciente_idPaciente_pk 
   CONSTRAINT     i   ALTER TABLE ONLY public.paciente
    ADD CONSTRAINT "paciente_idPaciente_pk" PRIMARY KEY ("idPaciente");
 K   ALTER TABLE ONLY public.paciente DROP CONSTRAINT "paciente_idPaciente_pk";
       public            postgres    false    220            u           2606    24708    rol rol_idRol_pk 
   CONSTRAINT     U   ALTER TABLE ONLY public.rol
    ADD CONSTRAINT "rol_idRol_pk" PRIMARY KEY ("idRol");
 <   ALTER TABLE ONLY public.rol DROP CONSTRAINT "rol_idRol_pk";
       public            postgres    false    222            w           2606    24717    usuario usuario_idUsuario_pk 
   CONSTRAINT     e   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT "usuario_idUsuario_pk" PRIMARY KEY ("idUsuario");
 H   ALTER TABLE ONLY public.usuario DROP CONSTRAINT "usuario_idUsuario_pk";
       public            postgres    false    225            l           1259    24681    fki_citas_idPaciente_fk    INDEX     S   CREATE INDEX "fki_citas_idPaciente_fk" ON public.citas USING btree ("idPaciente");
 -   DROP INDEX public."fki_citas_idPaciente_fk";
       public            postgres    false    216            m           1259    24734    fki_citas_idUsuario_fk    INDEX     Q   CREATE INDEX "fki_citas_idUsuario_fk" ON public.citas USING btree ("idUsuario");
 ,   DROP INDEX public."fki_citas_idUsuario_fk";
       public            postgres    false    216            p           1259    24699 "   fki_expedienteMedico_idPaciente_fk    INDEX     k   CREATE INDEX "fki_expedienteMedico_idPaciente_fk" ON public."expedienteMedico" USING btree ("idPaciente");
 8   DROP INDEX public."fki_expedienteMedico_idPaciente_fk";
       public            postgres    false    218            q           1259    24728 !   fki_expedienteMedico_idUsuario_fk    INDEX     i   CREATE INDEX "fki_expedienteMedico_idUsuario_fk" ON public."expedienteMedico" USING btree ("idUsuario");
 7   DROP INDEX public."fki_expedienteMedico_idUsuario_fk";
       public            postgres    false    218            x           2606    24676    citas citas_idPaciente_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.citas
    ADD CONSTRAINT "citas_idPaciente_fk" FOREIGN KEY ("idPaciente") REFERENCES public.paciente("idPaciente");
 E   ALTER TABLE ONLY public.citas DROP CONSTRAINT "citas_idPaciente_fk";
       public          postgres    false    4723    216    220            y           2606    24729    citas citas_idUsuario_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.citas
    ADD CONSTRAINT "citas_idUsuario_fk" FOREIGN KEY ("idUsuario") REFERENCES public.usuario("idUsuario");
 D   ALTER TABLE ONLY public.citas DROP CONSTRAINT "citas_idUsuario_fk";
       public          postgres    false    216    4727    225            z           2606    24694 /   expedienteMedico expedienteMedico_idPaciente_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public."expedienteMedico"
    ADD CONSTRAINT "expedienteMedico_idPaciente_fk" FOREIGN KEY ("idPaciente") REFERENCES public.paciente("idPaciente");
 ]   ALTER TABLE ONLY public."expedienteMedico" DROP CONSTRAINT "expedienteMedico_idPaciente_fk";
       public          postgres    false    4723    220    218            {           2606    24723 .   expedienteMedico expedienteMedico_idUsuario_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public."expedienteMedico"
    ADD CONSTRAINT "expedienteMedico_idUsuario_fk" FOREIGN KEY ("idUsuario") REFERENCES public.usuario("idUsuario");
 \   ALTER TABLE ONLY public."expedienteMedico" DROP CONSTRAINT "expedienteMedico_idUsuario_fk";
       public          postgres    false    218    4727    225            |           2606    24718    usuario usuario_idRol_fk    FK CONSTRAINT     |   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT "usuario_idRol_fk" FOREIGN KEY ("idRol") REFERENCES public.rol("idRol");
 D   ALTER TABLE ONLY public.usuario DROP CONSTRAINT "usuario_idRol_fk";
       public          postgres    false    225    4725    222                  x������ � �            x������ � �            x������ � �         &   x�3��MM�L��2�tL����,.)JL�/����� �-�         �   x�M�9n�0D��S���i�"���X�r�-��(�ɵr�\,_K5d��7� ��s��oz���w�6}�oޅ.�V�(�z/$4��XWea������1`�w]@H�M�$�O}�yC����?_��z��lϧ�FI0�g����2ET�w�=ս�LD�!������Tzji/V(S�RbA���^�L����OG�)g�o�F7rh�b�]ʠ�)�NS��m�y�~V�j�d�i7��1�~ +m`     